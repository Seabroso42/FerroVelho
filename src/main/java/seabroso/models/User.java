package seabroso.models;

import java.util.ArrayList;

public class User {
    private String nome;
    private String username;
    private String email;
    private long cpf;
    private ArrayList<Notificacao> Noti;
/*
    public User(String nome, String username, String email, long cpf) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        Noti = new ArrayList<Notificacao>();
    }

 */

    public ArrayList<Notificacao> getNoti() {
        return Noti;
    }

    public void setNoti(ArrayList<Notificacao> noti) {
        Noti = noti;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
