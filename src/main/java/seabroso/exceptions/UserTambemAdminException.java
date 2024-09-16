package seabroso.exceptions;

public class UserTambemAdminException extends RuntimeException {
    public UserTambemAdminException() {
        super("Usuário tem o mesmo nível de acesso que você!");
    }
}
