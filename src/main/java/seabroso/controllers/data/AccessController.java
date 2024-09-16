package seabroso.controllers.data;

import seabroso.models.User;

public class AccessController {
    private static AccessController instance;
    public static AccessController getInstance(){
        if(instance == null){
            instance = new AccessController();
        }
        return instance;
    }
    public static boolean checkAccess(User usuario, String methodName){
        return usuario.getCargo().isAllowed(methodName);
    }
}
