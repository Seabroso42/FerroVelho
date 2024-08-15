package seabroso.models;

import lombok.Data;

@Data
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

}
