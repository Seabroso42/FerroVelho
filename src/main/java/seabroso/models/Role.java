package seabroso.models;

import seabroso.enums.UserTypes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Role {
    UserTypes roleName;
    List<String> metodosPermitidos;

    public Role(UserTypes cargo, List<String> metodos){
        this.roleName= cargo;
        this.metodosPermitidos= metodos;
    }
    public boolean isAllowed(String method){
        return metodosPermitidos.contains(method);
    }

}
