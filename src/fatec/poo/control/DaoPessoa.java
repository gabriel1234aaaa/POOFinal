package fatec.poo.control;

import fatec.poo.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 0030481711046
 */
public class DaoPessoa {

    private Connection conn;

    public DaoPessoa(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Pessoa pessoa) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO PESSOA(CPF, NOME, DATANASC, "
                    + "ENDERECO, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, "
                    + "CELULAR, SEXO, ESTADOCIVIL, RG, EMAIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, pessoa.getCPF());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getDataNasc());
            ps.setString(4, pessoa.getEndereco());
            ps.setInt(5, pessoa.getNumero());
            ps.setString(6, pessoa.getBairro());
            ps.setString(7, pessoa.getCidade());
            ps.setString(8, pessoa.getEstado());
            ps.setString(9, pessoa.getCEP());
            ps.setString(10, pessoa.getTelefone());
            ps.setString(11, pessoa.getCelular());
            ps.setString(12, pessoa.getSexo());
            ps.setString(13, pessoa.getEstadoCivil());
            ps.setString(14, pessoa.getRG());
            ps.setString(15, pessoa.getEmail());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Pessoa pessoa) {
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("UPDATE PESSOA SET NOME = ?, DATANASC = ?, "
                    + "ENDERECO = ?, NUMERO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, "
                    + "CEP = ?, TELEFONE = ?, CELULAR = ?, SEXO = ?, ESTADOCIVIL = ?, "
                    + "RG = ?, EMAIL = ? WHERE CPF = ?");

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getDataNasc());
            ps.setString(3, pessoa.getEndereco());
            ps.setInt(4, pessoa.getNumero());
            ps.setString(5, pessoa.getBairro());
            ps.setString(6, pessoa.getCidade());
            ps.setString(7, pessoa.getEstado());
            ps.setString(8, pessoa.getCEP());
            ps.setString(9, pessoa.getTelefone());
            ps.setString(10, pessoa.getCelular());
            ps.setString(11, pessoa.getSexo());
            ps.setString(12, pessoa.getEstadoCivil());
            ps.setString(13, pessoa.getRG());
            ps.setString(14, pessoa.getEmail());
            ps.setString(15, pessoa.getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void excluir(Pessoa pessoa) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM PESSOA WHERE CPF = ?");

            ps.setString(1, pessoa.getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
