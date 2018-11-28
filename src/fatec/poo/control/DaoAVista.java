package fatec.poo.control;

import fatec.poo.model.AVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAVista {

    private Connection conn;

    public DaoAVista(Connection conn) {
        this.conn = conn;
    }

    public void inserir(AVista avista) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO AVISTA(CODIGO, VALOR, "
                    + "AGENCIA, NCHEQUE, PREDATA) VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, avista.getCodigo());
            ps.setDouble(2, avista.getValor());
            ps.setInt(3, avista.getAgencia());
            ps.setInt(4, avista.getNCheque());
            ps.setString(5, avista.getPreData());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public void alterar(AVista avista) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE AVISTA SET "
                    + "VALOR = ?, AGENCIA = ?, NCHEQUE = ?, "
                    + "PREDATA = ? WHERE CODIGO = ?");

            ps.setDouble(1, avista.getValor());
            ps.setInt(2, avista.getAgencia());
            ps.setInt(3, avista.getNCheque());
            ps.setString(4, avista.getPreData());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public AVista consultar(int codigo) {
        AVista avista = null;

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM AVISTA ap"
                    + "WHERE ap.CODIGO = ?");

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                avista = new AVista();
                avista.setCodigo(rs.getInt("CODIGO"));
                avista.setValor(rs.getDouble("VALOR"));
                avista.setAgencia(rs.getInt("AGENCIA"));
                avista.setNCheque(rs.getInt("NCHEQUE"));
                avista.setPreData(rs.getString("PREDATA"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return (avista);
    }

    public void excluir(AVista avista) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE MATRICULA SET CODAVISTA = null "
                    + "WHERE CODAVISTA = ?");

            ps.setInt(1, avista.getCodigo());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM AVISTA WHERE CODIGO = ?");

            ps.setInt(1, avista.getCodigo());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
