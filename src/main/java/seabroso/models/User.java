package seabroso.models;

import lombok.Data;
import seabroso.enums.UserTypes;

import java.util.ArrayList;

@Data
public abstract class User {
    private long id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private CarteiraDigital carteiraDigital;
    private long cpf;
    private UserTypes tipo;
    private ArrayList<Notificacao> notiLista;
    public User(){
        this.notiLista= new ArrayList<Notificacao>();
        this.carteiraDigital= new CarteiraDigital();
    }

}
