package seabroso.models;

public class Peca {
    private long idPeca;
    private Double valor;
    private String nome;
    private String fabricante;
    //private tipo ENUM
    private String modelo;
    //private estado de conserva enum
    private int estoque;

    public Peca(long idPeca, String nome, String fabricante, String modelo, int estoque) {
        this.idPeca = idPeca;
        this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.estoque = estoque;
    }
    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(long idPeca) {
        this.idPeca = idPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
