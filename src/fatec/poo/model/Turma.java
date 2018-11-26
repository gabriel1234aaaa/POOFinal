package fatec.poo.model;

import java.util.ArrayList;

public class Turma {
    private String SiglaTurma;
    private String Descricao;
    private String Datainicio;
    private String DataTermino;
    private String Periodo;
    private int QtdVagas;
    private String Observacoes;
    private Instrutor instrutor;
    private Curso curso;
    ArrayList<Matricula> mat_turma = new ArrayList<>();
    
    public Turma(String SiglaTurma, String Descricao) {
        this.SiglaTurma = SiglaTurma;
        this.Descricao = Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setDatainicio(String Datainicio) {
        this.Datainicio = Datainicio;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public void setQtdVagas(int QtdVagas) {
        this.QtdVagas = QtdVagas;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void addMatricula(Matricula m){
        m.setTurma(this);
        mat_turma.add(m);
    }

    public String getSiglaTurma() {
        return SiglaTurma;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getDatainicio() {
        return Datainicio;
    }

    public String getDataTermino() {
        return DataTermino;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public int getQtdVagas() {
        return QtdVagas;
    }

    public String getObservacoes() {
        return Observacoes;
    }
    
    
}
