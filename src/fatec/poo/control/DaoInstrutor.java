/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Churras
 */
public class DaoInstrutor {

    private Connection conn;

    public DaoInstrutor(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Instrutor instrutor) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO PESSOA(CPF, NOME, DATANASC, "
                    + "ENDERECO, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, "
                    + "CELULAR, SEXO, ESTADOCIVIL, RG, EMAIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getDataNasc());
            ps.setString(4, instrutor.getEndereco());
            ps.setInt(5, instrutor.getNumero());
            ps.setString(6, instrutor.getBairro());
            ps.setString(7, instrutor.getCidade());
            ps.setString(8, instrutor.getEstado());
            ps.setString(9, instrutor.getCEP());
            ps.setString(10, instrutor.getTelefone());
            ps.setString(11, instrutor.getCelular());
            ps.setString(12, instrutor.getSexo());
            ps.setString(13, instrutor.getEstadoCivil());
            ps.setString(14, instrutor.getRG());
            ps.setString(15, instrutor.getEmail());

            ps.execute();

            ps = conn.prepareStatement("INSERT INTO INSTRUTOR(CPF, FORMACAO, AREAATUACAO) VALUES (?, ?, ?)");
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getFormacao());
            ps.setString(3, instrutor.getAreaAtuacao());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("UPDATE PESSOA SET NOME = ?, DATANASC = ?, "
                    + "ENDERECO = ?, NUMERO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, "
                    + "CEP = ?, TELEFONE = ?, CELULAR = ?, SEXO = ?, ESTADOCIVIL = ?, "
                    + "RG = ?, EMAIL = ? WHERE CPF = ?");

            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getDataNasc());
            ps.setString(3, instrutor.getEndereco());
            ps.setInt(4, instrutor.getNumero());
            ps.setString(5, instrutor.getBairro());
            ps.setString(6, instrutor.getCidade());
            ps.setString(7, instrutor.getEstado());
            ps.setString(8, instrutor.getCEP());
            ps.setString(9, instrutor.getTelefone());
            ps.setString(10, instrutor.getCelular());
            ps.setString(11, instrutor.getSexo());
            ps.setString(12, instrutor.getEstadoCivil());
            ps.setString(13, instrutor.getRG());
            ps.setString(14, instrutor.getEmail());
            ps.setString(15, instrutor.getCPF());

            ps.execute();

            ps = conn.prepareStatement("UPDATE INSTRUTOR SET FORMACAO = ?, "
                    + "AREAATUACAO = ? WHERE CPF = ?");

            ps.setString(1, instrutor.getFormacao());
            ps.setString(2, instrutor.getAreaAtuacao());

            ps.execute();

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

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (instrutor);
    }

    public void excluir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM MATRICULA WHERE SIGLATURMA IN ("
                    + "SELECT SIGLATURMA FROM TURMA WHERE CPFINST = ?)");

            ps.setString(1, instrutor.getCPF());

            ps.execute();
            
            ps = conn.prepareStatement("DELETE FROM TURMA WHERE CPFINST = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM INSTRUTOR WHERE CPF = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM PESSOA WHERE CPF = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
