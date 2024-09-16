package seabroso.controllers.data;

import seabroso.enums.UserTypes;
import seabroso.models.Role;
import seabroso.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccessController {
    private static AccessController instance;
    private static List<String> metodosCliente = new ArrayList<>(Arrays.asList());
    private static List<String> metodosAdmin= new ArrayList<>(Arrays.asList());
    private static List<String> metodosVendedor= new ArrayList<>(Arrays.asList());
    private static final Role adminRole = new Role(UserTypes.ADMIN, metodosAdmin);
    private static final Role clientRole= new Role(UserTypes.CLIENTE, metodosCliente);
    private static final Role sellerRole= new Role(UserTypes.VENDEDOR, metodosVendedor);

    public static AccessController getInstance(){
        if(instance == null){
            instance = new AccessController();
        }
        return instance;
    }
    public static boolean checkAccess(User usuario, String methodName){
        UserTypes tipo= usuario.getTipo();
        boolean result = false;
        switch (tipo){
            case VENDEDOR -> {
                result= sellerRole.isAllowed(methodName);
                break;
            }
            case CLIENTE -> {
                result= clientRole.isAllowed(methodName);
                break;
            }
            case ADMIN -> {
                result= adminRole.isAllowed(methodName);
                break;
            }
        }
        return result;

    }
}
