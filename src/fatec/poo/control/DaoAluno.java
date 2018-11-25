package fatec.poo.control;

import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAluno {

    private Connection conn;

    public DaoAluno(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Aluno aluno) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO PESSOA(CPF, NOME, DATANASC, "
                    + "ENDERECO, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, "
                    + "CELULAR, SEXO, ESTADOCIVIL, RG, EMAIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getDataNasc());
            ps.setString(4, aluno.getEndereco());
            ps.setInt(5, aluno.getNumero());
            ps.setString(6, aluno.getBairro());
            ps.setString(7, aluno.getCidade());
            ps.setString(8, aluno.getEstado());
            ps.setString(9, aluno.getCEP());
            ps.setString(10, aluno.getTelefone());
            ps.setString(11, aluno.getCelular());
            ps.setString(12, aluno.getSexo());
            ps.setString(13, aluno.getEstadoCivil());
            ps.setString(14, aluno.getRG());
            ps.setString(15, aluno.getEmail());

            ps.execute();

            ps = conn.prepareStatement("INSERT INTO ALUNO(CPF, ESCOLARIDADE) VALUES (?, ?)");
            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getEscolaridade());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Aluno aluno) {
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("UPDATE PESSOA SET NOME = ?, DATANASC = ?, "
                    + "ENDERECO = ?, NUMERO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, "
                    + "CEP = ?, TELEFONE = ?, CELULAR = ?, SEXO = ?, ESTADOCIVIL = ?, "
                    + "RG = ?, EMAIL = ? WHERE CPF = ?");

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDataNasc());
            ps.setString(3, aluno.getEndereco());
            ps.setInt(4, aluno.getNumero());
            ps.setString(5, aluno.getBairro());
            ps.setString(6, aluno.getCidade());
            ps.setString(7, aluno.getEstado());
            ps.setString(8, aluno.getCEP());
            ps.setString(9, aluno.getTelefone());
            ps.setString(10, aluno.getCelular());
            ps.setString(11, aluno.getSexo());
            ps.setString(12, aluno.getEstadoCivil());
            ps.setString(13, aluno.getRG());
            ps.setString(14, aluno.getEmail());
            ps.setString(15, aluno.getCPF());

            ps.execute();

            ps = conn.prepareStatement("UPDATE ALUNO SET ESCOLARIDADE = ? "
                    + "WHERE CPF = ?");

            ps.setString(1, aluno.getEscolaridade());
            ps.setString(2, aluno.getCPF());

            ps.execute();

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

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (aluno);
    }

    public void excluir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM ALUNO WHERE CPF = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM PESSOA WHERE CPF = ?");

            ps.setString(1, aluno.getCPF());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
