package seabroso.controllers.data;

import lombok.Data;
import seabroso.enums.UserTypes;
import seabroso.models.User;

import java.util.List;
import java.util.Locale;

import static java.lang.String.valueOf;

@Data
public class Roles {
    private UserTypes role;
    private List<String> metodos;

    public static void checarAcesso(User usuario){
        if (usuario!=null){
            String tipo = valueOf(usuario.getTipo()).toLowerCase(Locale.ROOT);
            switch (tipo){
                case "admin":
                    break;

                case "vendedor":
                    break;

                case "cliente":
                    break;
            }
        } else {

        }
    }


}
