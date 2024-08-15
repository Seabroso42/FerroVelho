package seabroso.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notificacao {
    private User destino;
    private LocalDateTime momento;
    private String texto;
    //private enum importancia
    private Boolean lida;

    public Notificacao(User destino, String texto) {
        this.destino = destino;
        this.momento = LocalDateTime.now();
        this.texto = texto;
        this.lida = false;
    }

}
