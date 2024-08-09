package seabroso.models;

import java.time.LocalDateTime;

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

    public User getDestino() {
        return destino;
    }

    public void setDestino(User destino) {
        this.destino = destino;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getLida() {
        return lida;
    }

    public void setLida(Boolean lida) {
        this.lida = lida;
    }
}
