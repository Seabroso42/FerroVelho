package seabroso.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.UserTypes;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdmin extends User{


    public UserAdmin(){
        super();
    }
    public void concluiOcorrencia(){

    }
    public void enviaNoti(){

    }
    public void AlteraRankVendedor(UserTypes rank, UserVendedor vendedor){

    }
    public void penalizaUser(){

    }
    public void aprovaSaque(){

    }
}
