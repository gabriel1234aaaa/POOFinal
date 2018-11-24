package fatec.poo.model;

public class Aluno extends Pessoa {
    private String Escolaridade;
    private Matricula matricula;
    
    public Aluno(String Nome, String CPF) {
        super(Nome, CPF);
    }

    public Matricula getAluno_matricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
        matricula.setAluno(this);
    }
    
    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }

    public String getEscolaridade() {
        return Escolaridade;
    }
    
}
