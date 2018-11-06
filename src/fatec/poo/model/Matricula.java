package fatec.poo.model;

public class Matricula {

    private String Data;
    private int QtdeFaltas;
    private double Nota;
    private Aluno aluno;
    private APrazo aprazo;
    private AVista avista;
    private Turma turma;

    public void setQtdeFaltas(int QtdeFaltas) {
        this.QtdeFaltas = QtdeFaltas;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public Matricula(String Data) {
        this.Data = Data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public APrazo getAprazo() {
        return aprazo;
    }

    public AVista getAvista() {
        return avista;
    }

    public void setAprazo(APrazo aprazo) {
        avista = null;
        this.aprazo = aprazo;
    }

    public void setAvista(AVista avista) {
        aprazo = null;
        this.avista = avista;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
