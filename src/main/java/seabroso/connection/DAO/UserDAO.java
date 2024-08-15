package seabroso.connection.DAO;

import seabroso.connection.DataCon;
import seabroso.enums.UserTypes;
import seabroso.models.User;
import seabroso.models.UserAdmin;
import seabroso.models.UserCliente;
import seabroso.models.UserVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserDAO {
//CREATE
    public static void cadastroUser(User usuario){
        String sql= "INSERT INTO USUARIOS (cpf, tipo, iduser, nome, email, senha, idcarteira, username) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps= null;
        try {
           ps= DataCon.getConexao().prepareStatement(sql);
           ps.setString(1, String.valueOf(usuario.getCpf()));
           ps.setString(2, String.valueOf(usuario.getTipo()));
           ps.setLong(3,usuario.getId());
           ps.setString(4, usuario.getNome());
           ps.setString(5, usuario.getEmail());
           ps.setString(6, usuario.getSenha());
           ps.setLong(7, usuario.getCarteiraDigital().getCarteiraId());
           ps.setString(8, usuario.getUsername());

           ps.execute();
           System.out.println("Usuário cadastrado com sucesso!");
           ps.close();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }

    }
//DELETE
    public static void deletaUser(User usuario){
        String sql = "DELETE FROM USUARIOS WHERE iduser = ?";
        PreparedStatement ps = null;
        try {
           ps= DataCon.getConexao().prepareStatement(sql);
           ps.setLong(1, usuario.getId());
           ps.execute();
            System.out.println("Usuário removido permanentemente.");

        }catch(SQLException | NullPointerException e) {
            System.out.println("Usuário não deletado.");
            e.printStackTrace();
        }

    }
    public static void deletaUser(long cpf){
        String sql = "DELETE FROM USUARIOS WHERE cpf = ?";
        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setString(1, String.valueOf(cpf));
            ps.execute();
            System.out.println("Usuário removido permanentemente.");

        }catch(SQLException | NullPointerException e) {
            System.out.println("Usuário não deletado.");
            e.printStackTrace();
        }

    }
//READ
    public static List<User> listaUser(){
        List<User> listaBusca= null;
        String sql = "SELECT * FROM USUARIOS";

        ResultSet busca= null;

        try {
            PreparedStatement ps = Objects.requireNonNull(DataCon.getConexao().prepareStatement(sql));
            busca = ps.executeQuery();
            while (busca.next()){

                String tipo= busca.getString("tipo").toLowerCase();

                switch (tipo){
                  case "admin":
                      try {
                          UserAdmin usuario = new UserAdmin();
                          usuario.setId(busca.getLong("iduser"));
                          usuario.setCpf(Long.parseLong(busca.getString("cpf")));
                          usuario.setNome(busca.getString("nome"));
                          usuario.setEmail(busca.getString("email"));
                          usuario.setSenha(busca.getString("senha"));
                          usuario.setUsername(busca.getString("username"));
                          listaBusca.add(usuario);

                      }catch (NullPointerException | NumberFormatException e){
                          System.out.println("erro na conversão de dados na listagem. -" + e.getMessage());
                          e.printStackTrace();
                      }
                      break;

                  case "cliente":
                      try {
                          UserCliente usuario = new UserCliente();
                          usuario.setId(busca.getLong("iduser"));
                          usuario.setCpf(Long.parseLong(busca.getString("cpf")));
                          usuario.setNome(busca.getString("nome"));
                          usuario.setEmail(busca.getString("email"));
                          usuario.setSenha(busca.getString("senha"));
                          usuario.setUsername(busca.getString("username"));
                          usuario.setEndereco(busca.getString("endereço"));
                          listaBusca.add(usuario);

                      }catch (NullPointerException | NumberFormatException e){
                          System.out.println("erro na conversão de dados na listagem. -" + e.getMessage());
                          e.printStackTrace();
                      }

                      break;


                  case "vendedor":

                      try {
                          UserVendedor usuario= new UserVendedor();
                          usuario.setId(busca.getLong("iduser"));
                          usuario.setCpf(Long.parseLong(busca.getString("cpf")));
                          usuario.setNome(busca.getString("nome"));
                          usuario.setEmail(busca.getString("email"));
                          usuario.setSenha(busca.getString("senha"));
                          usuario.setUsername(busca.getString("username"));
                          listaBusca.add(usuario);

                      }catch (NullPointerException | NumberFormatException e){
                          System.out.println("erro na conversão de dados na listagem. -" + e.getMessage());
                          e.printStackTrace();
                      }
                      break;

                  default:
                      System.out.println("tipo inválido");
                      break;
                }

            }

        }catch(SQLException | NullPointerException e) {
            System.out.println("deu errado ne ze");
            e.printStackTrace();
        }
        return listaBusca;

    }
//UPDATE
    public static void atualizaUser(User usuario){
        String sql = "UPDATE USUARIOS SET cpf= ?, tipo= ?,nome= ?, email= ?, senha= ?, idcarteira= ?, username = ?" + "WHERE iduser = ? ";
        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            //dados
            ps.setString(1, String.valueOf(usuario.getCpf()));
            ps.setString(2, String.valueOf(usuario.getTipo()));
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            ps.setLong(6, usuario.getCarteiraDigital().getCarteiraId());
            ps.setString(7, usuario.getUsername());

            //usuario a ser atualizado
            ps.setLong(8,usuario.getId());

            ps.execute();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("procedimento abortado." + e.getMessage());
            e.printStackTrace();
        }

    }
}
