package fatec.poo.control;

import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Churras
 */
public class DaoTurma {

    private Connection conn;

    public DaoTurma(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Turma turma) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO TURMA(SIGLATURMA, SIGLACURSO, "
                    + "CPFINST, DESCRICAO, DATAINICIO, DATATERMINO, PERIODO, "
                    + "QTDEVAGAS, OBSERVACOES) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?)");

            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getCurso().getSigla());
            ps.setString(3, turma.getInstrutor().getCPF());
            ps.setString(4, turma.getDescricao());
            ps.setString(5, turma.getDatainicio());
            ps.setString(6, turma.getDataTermino());
            ps.setString(7, turma.getPeriodo());
            ps.setInt(8, turma.getQtdVagas());
            ps.setString(9, turma.getObservacoes());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("UPDATE TURMA SET SIGLACURSO = ?, CPFINST = ?, "
                    + "DESCRICAO = ?, DATAINICIO = ?, DATATERMINO = ?, PERIODO = ?, "
                    + "QTDEVAGAS = ?, OBSERVACOES = ? WHERE SIGLATURMA= ?");

            ps.setString(1, turma.getCurso().getSigla());
            ps.setString(2, turma.getInstrutor().getCPF());
            ps.setString(3, turma.getDescricao());
            ps.setString(4, turma.getDatainicio());
            ps.setString(5, turma.getDataTermino());
            ps.setString(6, turma.getPeriodo());
            ps.setInt(7, turma.getQtdVagas());
            ps.setString(8, turma.getObservacoes());
            ps.setString(9, turma.getSiglaTurma());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Turma consultar(String sigla) {
        Turma turma = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TURMA t "
                    + " WHERE t.SIGLATURMA = ?");

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                DaoCurso daoCurso = new DaoCurso(conn);
                DaoInstrutor daoInstrutor = new DaoInstrutor(conn);
                Curso curso = daoCurso.consultar(rs.getString("SIGLACURSO"));
                Instrutor instrutor = daoInstrutor.consultar(rs.getString("CPFINST"));
                turma = new Turma(sigla, rs.getString("DESCRICAO)"));
                turma.setCurso(curso);
                turma.setInstrutor(instrutor);
                turma.setDatainicio(rs.getString("DATAINICIO"));
                turma.setDataTermino(rs.getString("DATATERMINO"));
                turma.setPeriodo(rs.getString("PERIODO"));
                turma.setQtdVagas(rs.getInt("QTDEVAGAS"));
                turma.setObservacoes(rs.getString("OBSERVACOES"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (turma);
    }

    public ArrayList<String> consultarCursos() {
        ArrayList<String> cursos = new ArrayList<>();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM CURSO");

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                cursos.add(rs.getString("NOME"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (cursos);
    }

    public void excluir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM MATRICULA WHERE SIGLATURMA = ?");

            ps.setString(1, turma.getSiglaTurma());

            ps.execute();

            ps = conn.prepareStatement("DELETE FROM TURMA WHERE SIGLATURMA = ?");

            ps.setString(1, turma.getSiglaTurma());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
