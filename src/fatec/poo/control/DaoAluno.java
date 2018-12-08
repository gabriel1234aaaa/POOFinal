package fatec.poo.control;

import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAluno {

    private Connection conn;
    private DaoPessoa daoPessoa;

    public DaoAluno(Connection conn) {
        this.conn = conn;
        daoPessoa = new DaoPessoa(conn);
    }

    public void inserir(Aluno aluno) {
        PreparedStatement ps = null;

        try {

            daoPessoa.inserir(aluno);

            ps = conn.prepareStatement("INSERT INTO ALUNO(CPF, ESCOLARIDADE) VALUES (?, ?)");
            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getEscolaridade());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            daoPessoa.alterar(aluno);

            ps = conn.prepareStatement("UPDATE ALUNO SET ESCOLARIDADE = ? "
                    + "WHERE CPF = ?");

            ps.setString(1, aluno.getEscolaridade());
            ps.setString(2, aluno.getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Aluno consultar(String cpf) {
        Aluno aluno = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM ALUNO a "
                    + "INNER JOIN PESSOA p ON a.CPF = p.CPF"
                    + " WHERE a.CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                aluno = new Aluno(rs.getString("NOME"), cpf);
                aluno.setDataNasc(rs.getString("DATANASC"));
                aluno.setEndereco(rs.getString("ENDERECO"));
                aluno.setNumero(rs.getInt("NUMERO"));
                aluno.setBairro(rs.getString("BAIRRO"));
                aluno.setCidade(rs.getString("CIDADE"));
                aluno.setEstado(rs.getString("ESTADO"));
                aluno.setCEP(rs.getString("CEP"));
                aluno.setTelefone(rs.getString("TELEFONE"));
                aluno.setCelular(rs.getString("CELULAR"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setEstadoCivil(rs.getString("ESTADOCIVIL"));
                aluno.setRG(rs.getString("RG"));
                aluno.setEmail(rs.getString("EMAIL"));
                aluno.setEscolaridade(rs.getString("ESCOLARIDADE"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (aluno);
    }

    public void excluir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM MATRICULA WHERE CPFALUNO = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM ALUNO WHERE CPF = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM PESSOA WHERE CPF = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
