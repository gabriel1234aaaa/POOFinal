/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import fatec.poo.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Churras
 */
public class DaoInstrutor {

    private Connection conn;
    private DaoPessoa daoPessoa;

    public DaoInstrutor(Connection conn) {
        this.conn = conn;
        daoPessoa = new DaoPessoa(conn);
    }

    public void inserir(Instrutor instrutor) {
        PreparedStatement ps = null;

        try {
            daoPessoa.inserir(instrutor);

            ps = conn.prepareStatement("INSERT INTO INSTRUTOR(CPF, FORMACAO, AREAATUACAO) VALUES (?, ?, ?)");
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getFormacao());
            ps.setString(3, instrutor.getAreaAtuacao());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            daoPessoa.alterar(instrutor);

            ps = conn.prepareStatement("UPDATE INSTRUTOR SET FORMACAO = ?, "
                    + "AREAATUACAO = ? WHERE CPF = ?");

            ps.setString(1, instrutor.getFormacao());
            ps.setString(2, instrutor.getAreaAtuacao());
            ps.setString(3, instrutor.getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Instrutor consultar(String cpf) {
        Instrutor instrutor = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM INSTRUTOR i "
                    + "INNER JOIN PESSOA p ON i.CPF = p.CPF"
                    + " WHERE i.CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                instrutor = new Instrutor(rs.getString("NOME"), cpf);
                instrutor.setDataNasc(rs.getString("DATANASC"));
                instrutor.setEndereco(rs.getString("ENDERECO"));
                instrutor.setNumero(rs.getInt("NUMERO"));
                instrutor.setBairro(rs.getString("BAIRRO"));
                instrutor.setCidade(rs.getString("CIDADE"));
                instrutor.setEstado(rs.getString("ESTADO"));
                instrutor.setCEP(rs.getString("CEP"));
                instrutor.setTelefone(rs.getString("TELEFONE"));
                instrutor.setCelular(rs.getString("CELULAR"));
                instrutor.setSexo(rs.getString("SEXO"));
                instrutor.setEstadoCivil(rs.getString("ESTADOCIVIL"));
                instrutor.setRG(rs.getString("RG"));
                instrutor.setEmail(rs.getString("EMAIL"));
                instrutor.setFormacao(rs.getString("FORMACAO"));
                instrutor.setAreaAtuacao(rs.getString("AREAATUACAO"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (instrutor);
    }

    public ArrayList<Instrutor> consultarInstrutores() {
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        Instrutor instrutor = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM INSTRUTOR i "
                    + "INNER JOIN PESSOA p ON i.CPF = p.CPF");

            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) {
                instrutor = new Instrutor(rs.getString("NOME"), rs.getString("CPF"));
                instrutor.setDataNasc(rs.getString("DATANASC"));
                instrutor.setEndereco(rs.getString("ENDERECO"));
                instrutor.setNumero(rs.getInt("NUMERO"));
                instrutor.setBairro(rs.getString("BAIRRO"));
                instrutor.setCidade(rs.getString("CIDADE"));
                instrutor.setEstado(rs.getString("ESTADO"));
                instrutor.setCEP(rs.getString("CEP"));
                instrutor.setTelefone(rs.getString("TELEFONE"));
                instrutor.setCelular(rs.getString("CELULAR"));
                instrutor.setSexo(rs.getString("SEXO"));
                instrutor.setEstadoCivil(rs.getString("ESTADOCIVIL"));
                instrutor.setRG(rs.getString("RG"));
                instrutor.setEmail(rs.getString("EMAIL"));
                instrutor.setFormacao(rs.getString("FORMACAO"));
                instrutor.setAreaAtuacao(rs.getString("AREAATUACAO"));

                instrutores.add(instrutor);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (instrutores);
    }

    public void excluir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TURMA SET CPFINST = null WHERE CPFINST = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM INSTRUTOR WHERE CPF = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();

            daoPessoa.excluir(instrutor);
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
