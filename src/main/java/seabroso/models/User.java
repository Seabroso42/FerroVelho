package seabroso.models;

import lombok.Data;
import seabroso.enums.UserTypes;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public abstract class User {
    private String imageURL;
    private long id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private CarteiraDigital carteiraDigital;
    private long cpf;
    private UserTypes tipo;
    private Role cargo;
    private LinkedList<Ocorrencia> notiLista;
    public User(){
        this.notiLista= new LinkedList<>();
        this.carteiraDigital= new CarteiraDigital();
        this.cargo= new Role(this.getTipo());
    }

}
