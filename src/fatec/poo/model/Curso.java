package fatec.poo.model;

import java.util.ArrayList;

public class Curso {

    private String Sigla;
    private String Nome;
    private int CargaHoraria;
    private double Valor;
    private String dataVigencia;
    private double ValorHoraInstrutor;
    private String Programa;
    ArrayList<Turma> curso_turma = new ArrayList<>();

    public Curso(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setDataVigencia(String dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public void setValorHoraInstrutor(double ValorHoraInstrutor) {
        this.ValorHoraInstrutor = ValorHoraInstrutor;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }

    public void addTurma(Turma t) {
        t.setCurso(this);
        curso_turma.add(t);
    }

    public String getSigla() {
        return Sigla;
    }

    public String getNome() {
        return Nome;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public double getValor() {
        return Valor;
    }

    public String getDataVigencia() {
        return dataVigencia;
    }

    public double getValorHoraInstrutor() {
        return ValorHoraInstrutor;
    }

    public String getPrograma() {
        return Programa;
    }

    
    
}
