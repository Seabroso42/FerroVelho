package seabroso.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataCon {
    private static final String URLDATA= "jdbc:mysql://monorail.proxy.rlwy.net:38525/ferroVelho";
    private static final String DATAUSERNAME= "root";
    private static final String DATAPASSWORD= "NwXeYxVHfDuHqODHvvdWuQyajIoVVlhe";
    private static Connection conexao;

    public static void main(String[] args) {

    }

    public static Connection getConexao() {
        try{
            if (conexao == null){
                conexao= DriverManager.getConnection(URLDATA, DATAUSERNAME, DATAPASSWORD);
                return conexao;
            }else {
                return conexao;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

}