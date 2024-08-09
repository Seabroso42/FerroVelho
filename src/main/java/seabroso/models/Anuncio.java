package seabroso.models;

public class Anuncio {
    private long idAnuncio;
    private User dono;
    private Peca produto;
    private String titulo;
    private String descricao;
    private Boolean isAtivo;
    private String cidade;

    public Anuncio(long idAnuncio, User dono, Peca produto, String titulo, String descricao, Boolean isAtivo, String cidade) {
        this.idAnuncio = idAnuncio;
        this.dono = dono;
        this.produto = produto;
        this.titulo = titulo;
        this.descricao = descricao;
        this.isAtivo = isAtivo;
        this.cidade = cidade;
    }

    public static void main(String[] args) {

    }

    public void addCarrinho(){

    }

    public long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public User getDono() {
        return dono;
    }

    public void setDono(User dono) {
        this.dono = dono;
    }

    public Peca getProduto() {
        return produto;
    }

    public void setProduto(Peca produto) {
        this.produto = produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
