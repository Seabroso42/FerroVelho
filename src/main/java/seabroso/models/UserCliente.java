package seabroso.models;

public class UserCliente extends User{
    private long userId;
    private String adress;
    public UserCliente(){

    }
    public Ocorrencia reclamar(UserVendedor culpado, String descricao){

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
