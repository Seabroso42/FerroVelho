package seabroso.models;

import seabroso.enums.UserTypes;

import java.util.HashSet;
import java.util.Set;

public class Role {
    UserTypes roleName;
    Set<String> metodosPermitidos;

    public Role(UserTypes cargo){
        this.roleName= cargo;
        this.metodosPermitidos= new HashSet<>();
    }
    public boolean isAllowed(String method){
        return metodosPermitidos.contains(method);
    }

}
