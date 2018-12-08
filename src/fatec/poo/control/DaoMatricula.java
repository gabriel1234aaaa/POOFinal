package fatec.poo.control;

import fatec.poo.model.APrazo;
import fatec.poo.model.AVista;
import fatec.poo.model.Matricula;
import fatec.poo.model.Turma;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DaoMatricula {

    private Connection conn;

    public DaoMatricula(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Matricula matricula) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO MATRICULA(DTMATRICULA, QTDEFALTAS, "
                    + "NOTA, CPFALUNO, CODAPRAZO, CODAVISTA, SIGLATURMA)"
                    + "VALUES (?, ?, ?, ?, ?, ? , ?)");

            ps.setString(1, matricula.getData());
            ps.setInt(2, matricula.getQtdeFaltas());
            ps.setDouble(3, matricula.getNota());
            ps.setString(4, matricula.getAluno().getCPF());
            
             if (matricula.getAprazo() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, matricula.getAprazo().getCodigo());
            }

            if (matricula.getAvista() == null) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, matricula.getAvista().getCodigo());
            }
            ps.setString(7, matricula.getTurma().getSiglaTurma());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public void alterar(Matricula matricula) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE MATRICULA SET DTMATRICULA = ?, "
                    + "CODAPRAZO = ?, CODAVISTA = ? WHERE SIGLATURMA = ? "
                    + "AND CPFALUNO = ?");

            ps.setString(1, matricula.getData());

            if (matricula.getAprazo() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, matricula.getAprazo().getCodigo());
            }

            if (matricula.getAvista() == null) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, matricula.getAvista().getCodigo());
            }
            ps.setString(4, matricula.getTurma().getSiglaTurma());
            ps.setString(5, matricula.getAluno().getCPF());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public Matricula consultar(String cpf, String sigla) {
        Matricula matricula = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM MATRICULA "
                    + "WHERE CPFALUNO = ? AND SIGLATURMA = ?");

            ps.setString(1, cpf);
            ps.setString(2, sigla);

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                DaoAluno da = new DaoAluno(conn);
                DaoTurma dt = new DaoTurma(conn);
                DaoAPrazo dap = new DaoAPrazo(conn);
                DaoAVista dav = new DaoAVista(conn);

                matricula = new Matricula(rs.getString("DTMATRICULA"));
                matricula.setQtdeFaltas(rs.getInt("QTDEFALTAS"));
                matricula.setNota(rs.getDouble("NOTA"));

                matricula.setAluno(da.consultar(cpf));

                BigDecimal idPrazo = (BigDecimal) rs.getObject("CODAPRAZO");
                BigDecimal idVista = (BigDecimal) rs.getObject("CODAVISTA");

                if (idPrazo != null) {
                    matricula.setAprazo(dap.consultar(idPrazo.intValue()));
                } else {
                    matricula.setAprazo(null);
                }

                if (idVista != null) {
                    matricula.setAvista(dav.consultar(idVista.intValue()));
                } else {
                    matricula.setAvista(null);
                }

                matricula.setTurma(dt.consultar(sigla));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (matricula);
    }

    public void excluir(Matricula matricula) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM MATRICULA "
                    + "WHERE CPFALUNO = ? AND SIGLATURMA = ?");

            ps.setString(1, matricula.getAluno().getCPF());
            ps.setString(2, matricula.getTurma().getSiglaTurma());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
