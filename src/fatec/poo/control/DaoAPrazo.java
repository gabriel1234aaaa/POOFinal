package fatec.poo.control;

import fatec.poo.model.APrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAPrazo {

    private Connection conn;

    public DaoAPrazo(Connection conn) {
        this.conn = conn;
    }

    public void inserir(APrazo aprazo) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO APRAZO(VALOR, "
                    + "DTVENCIMENTO, TAXAJUROS, QTDEMENSALIDADE, CODIGO) "
                    + "VALUES (?, ?, ?, ?, ?)");

            ps.setDouble(1, aprazo.getValor());
            ps.setString(2, aprazo.getDtVencimento());
            ps.setDouble(3, aprazo.getTaxaJuros());
            ps.setInt(4, aprazo.getQtdeMensalidade());
            ps.setInt(5, aprazo.getCodigo());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public int ultRegistro() {
        int ultReg = 0;

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT CODIGO FROM APRAZO "
                    + "WHERE ROWNUM = 1 ORDER BY CODIGO DESC");

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                ultReg = rs.getInt("CODIGO");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return (ultReg);
    }

    public void alterar(APrazo aprazo) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE APRAZO SET "
                    + "VALOR = ?, DTVENCIMENTO = ?, TAXAJUROS = ?, "
                    + "QTDEMENSALIDADE = ? WHERE CODIGO = ?");

            ps.setDouble(1, aprazo.getValor());
            ps.setString(2, aprazo.getDtVencimento());
            ps.setDouble(3, aprazo.getTaxaJuros());
            ps.setInt(4, aprazo.getQtdeMensalidade());
            ps.setInt(5, aprazo.getCodigo());

            ps.execute();

            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public APrazo consultar(int codigo) {
        APrazo aprazo = null;

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM APRAZO ap "
                    + "WHERE ap.CODIGO = ?");

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                aprazo = new APrazo();
                aprazo.setCodigo(rs.getInt("CODIGO"));
                aprazo.setDtVencimento(rs.getString("DTVENCIMENTO"));
                aprazo.setQtdeMensalidade(rs.getInt("QTDEMENSALIDADE"));
                aprazo.setTaxaJuros(rs.getDouble("TAXAJUROS"));
                aprazo.setValor(rs.getDouble("VALOR"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return (aprazo);
    }

    public void excluir(APrazo aprazo) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE MATRICULA SET CODAPRAZO = null "
                    + "WHERE CODAPRAZO = ?");

            ps.setInt(1, aprazo.getCodigo());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM APRAZO WHERE CODIGO = ?");

            ps.setInt(1, aprazo.getCodigo());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
