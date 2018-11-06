package fatec.poo.model;

public class APrazo {
    private double Valor;
    private String DtVencimento;
    private double TaxaJuros;
    private int QtdeMensalidade;

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setDtVencimento(String DtVencimento) {
        this.DtVencimento = DtVencimento;
    }

    public void setTaxaJuros(double TaxaJuros) {
        this.TaxaJuros = TaxaJuros/100;
    }

    public void setQtdeMensalidade(int QtdeMensalidade) {
        this.QtdeMensalidade = QtdeMensalidade;
    }
    
}
