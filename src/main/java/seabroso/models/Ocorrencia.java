package seabroso.models;

public class Ocorrencia {
    private User remetente;
    private String descricao;
    private User culpado;
    private User assistente;
    private Boolean isResolvida;

    public Ocorrencia(User remetente, String descricao, User culpado, User assistente) {
        this.remetente = remetente;
        this.descricao = descricao;
        this.culpado = culpado;
        this.assistente = assistente;
        this.isResolvida= false;
    }

    public User getRemetente() {
        return remetente;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getCulpado() {
        return culpado;
    }

    public void setCulpado(User culpado) {
        this.culpado = culpado;
    }

    public User getAssistente() {
        return assistente;
    }

    public void setAssistente(User assistente) {
        this.assistente = assistente;
    }

    public Boolean getResolvida() {
        return isResolvida;
    }

    public void setResolvida(Boolean resolvida) {
        isResolvida = resolvida;
    }
}
