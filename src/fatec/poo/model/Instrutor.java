package fatec.poo.model;

import java.util.ArrayList;

public class Instrutor extends Pessoa {
    private String Formacao;
    private String AreaAtuacao;
    ArrayList<Turma> inst_turma = new ArrayList<>();
    
    public Instrutor(String Nome, String CPF) {
        super(Nome, CPF);
    }
    
    public void addTurma(Turma t){
        t.setInstrutor(this);
        inst_turma.add(t);
    }
    
    public void setFormacao(String Formacao) {
        this.Formacao = Formacao;
    }

    public void setAreaAtuacao(String AreaAtuacao) {
        this.AreaAtuacao = AreaAtuacao;
    }

    public String getFormacao() {
        return Formacao;
    }

    public String getAreaAtuacao() {
        return AreaAtuacao;
    }
    
    
    
}
