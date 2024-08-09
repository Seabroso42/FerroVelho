package seabroso.connection.DAO;

import seabroso.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    public static void cadastroUser(){
        try {

        }catch(SQLException | NullPointerException e) {
            System.out.println("falha no cadastro.");
            e.printStackTrace();
        }

    }
    public static void deletaUser(){
        try {

        }catch(SQLException | NullPointerException e) {
            System.out.println("Usuário não deletado.");
            e.printStackTrace();
        }

    }
    public static List<User> listaUser(){
        List<User> listaBusca= null;
        try {

        }catch(SQLException | NullPointerException e) {
            System.out.println("deu errado ne ze");
            e.printStackTrace();
        }
        return listaBusca;

    }
    public static void atualizaUser(User usuario){
        try {

        }catch(SQLException | NullPointerException e) {
            System.out.println("procedimento abortado.");
            e.printStackTrace();
        }

    }
}
