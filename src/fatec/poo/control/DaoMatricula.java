package fatec.poo.control;

import fatec.poo.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            ps.setInt(5, matricula.getAprazo().getCodigo());
            ps.setInt(6, matricula.getAvista().getCodigo());
            ps.setString(7, matricula.getTurma().getSiglaTurma());

            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    public void alterar(Matricula matricula){
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE MATRICULA SET DTMATRICULA = ?, " 
                    + "QTDEFALTAS = ?, NOTA = ?, CODAPRAZO = ?, "
                    + "CODAVISTA = ? WHERE SIGLATURMA = ? AND CPFALUNO = ?");
            
            ps.setString(1, matricula.getData());
            ps.setInt(2, matricula.getQtdeFaltas());
            ps.setDouble(3, matricula.getNota());
            ps.setInt(4, matricula.getAprazo().getCodigo());
            ps.setInt(5, matricula.getAvista().getCodigo());
            ps.setString(6, matricula.getTurma().getSiglaTurma());
            ps.setString(7, matricula.getAluno().getCPF());
            
            ps.execute();
            
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
                
                matricula = new Matricula();
                
                matricula.setData(rs.getString("DTMATRICULA"));
                matricula.setQtdeFaltas(rs.getInt("QTDEFALTAS"));
                matricula.setNota(rs.getDouble("NOTA"));
                
                DaoAluno da = new DaoAluno(conn);
                DaoTurma dt = new DaoTurma(conn);
                DaoAPrazo dap = new DaoAPrazo(conn);
                
                matricula.setAluno(da.consultar(cpf));
                matricula.setAprazo(dap.consultar(rs.getInt("CODAPRAZO")));
                matricula.setTurma(dt.consultar(sigla));
                
            }

            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (matricula);
    }
    
    
}
