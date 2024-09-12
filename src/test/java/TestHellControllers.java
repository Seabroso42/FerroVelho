import seabroso.enums.UserTypes;
import seabroso.models.Role;

public class TestHellControllers {
    public static void main(String[] args) {
        //criando os roles pro controle de acesso
        Role adminRole = new Role(UserTypes.ADMIN);
        Role clientRole= new Role(UserTypes.CLIENTE);
        Role sellerRole= new Role(UserTypes.VENDEDOR);
        //testes com métodos dos Controllers
        System.out.println("-----testes controllers-----");
    }

}
