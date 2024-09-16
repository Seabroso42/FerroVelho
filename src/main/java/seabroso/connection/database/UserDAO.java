package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;
import seabroso.models.User;
import seabroso.models.UserAdmin;
import seabroso.models.UserCliente;
import seabroso.models.UserVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//propagar as exceções para as interfaces graficas 


public class UserDAO{
    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null){
            instance = new UserDAO();
            return instance;
        }else {
            return instance;
        }
    }

    //CREATE
    public void cadastroUserVendedor(UserVendedor usuario){
        String sql= "INSERT INTO USUARIOS (cpf, tipo, iduser, nome, email, senha, idcarteira, username, endereço, imageurl, ranking) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(9, "Não-declarado");
            ps.setString(10, usuario.getImageURL());
            ps.setString(11, String.valueOf(usuario.getRank()));

            ps.execute();
            ps.close();
            System.out.println("Vendedor cadastrado com sucesso!");

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }
    }
    public void cadastroUserCliente(UserCliente usuario){
        String sql= "INSERT INTO USUARIOS (cpf, tipo, iduser, nome, email, senha, idcarteira, username, endereço, imageurl) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
           ps.setString(9, usuario.getEndereco());
           ps.setString(10, usuario.getImageURL());

           ps.execute();
           ps.close();
           System.out.println("Cliente cadastrado com sucesso!");

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }

    }
    public void cadastroUserAdmin(UserAdmin usuario){
        String sql= "INSERT INTO USUARIOS (cpf, tipo, iduser, nome, email, senha, idcarteira, username, endereço, imageurl) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setString(1, String.valueOf(usuario.getCpf()));
            ps.setString(2, String.valueOf(usuario.getTipo()));
            ps.setLong(3,usuario.getId());
            ps.setString(4, usuario.getNome());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getSenha());
            ps.setLong(7, 0);
            ps.setString(8, usuario.getUsername());
            ps.setString(9, "central");
            ps.setString(10, usuario.getImageURL());

            ps.execute();
            ps.close();
            System.out.println("Admin cadastrado com sucesso!");

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }

    }

//DELETE
    public void deletaUser(User usuario){
        String sql = "DELETE FROM USUARIOS WHERE iduser = ?";
        PreparedStatement ps = null;
        try {
           ps= DataCon.getConexao().prepareStatement(sql);
           ps.setLong(1, usuario.getId());
           ps.execute();
           ps.close();
            System.out.println("Usuário removido permanentemente.");

        }catch(SQLException | NullPointerException e) {
            System.out.println("Usuário não deletado.");
            e.printStackTrace();
        }

    }
    public void deletaUser(long cpf){
        String sql = "DELETE FROM USUARIOS WHERE cpf = ?";
        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setString(1, String.valueOf(cpf));
            ps.execute();
            ps.close();
            System.out.println("Usuário removido permanentemente.");

        }catch(SQLException | NullPointerException e) {
            System.out.println("Usuário não deletado.");
            e.printStackTrace();
        }

    }
//READ
    public Set<User> listaUser(){
        Set<User> listaBusca= new HashSet<>();
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
                          usuario.setImageURL(busca.getString("imageurl"));
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
                          usuario.setImageURL(busca.getString("imageurl"));
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
                          usuario.setImageURL(busca.getString("imageurl"));
                          usuario.setRank(VendorRanks.valueOf(busca.getString("ranking")));
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
    public Optional<User> buscaUsuario(long identificador){
        Set<User> pesquisa= listaUser();
        Optional<User> resultado = Optional.empty();

            for (User usuario : pesquisa){
                if (usuario.getId() == identificador | usuario.getCpf() == identificador){
                    resultado= Optional.of(usuario);
                } else {
                    break;
                }
            }

        return resultado;
    }
    public Optional<UserVendedor> buscaVendedor(long identificador){
        Set<User> pesquisa= listaUser();
        Optional<UserVendedor> resultado= Optional.empty();
        for (User usuario : pesquisa){
            if (usuario.getTipo().equals(UserTypes.VENDEDOR)){
                if (usuario.getId() == identificador | usuario.getCpf() == identificador){
                    resultado= Optional.of((UserVendedor) usuario);
                } else {
                    break;
                }
            } else {
                break;
            }

        }

        return resultado;
    }
//UPDATE
    public void atualizaUser(UserCliente usuario){
        String sql = "UPDATE USUARIOS SET cpf= ?, tipo= ?,nome= ?, email= ?, senha= ?, idcarteira= ?, username = ?, endereço= ?, imageurl= ?" + "WHERE iduser = ? ";
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
            ps.setString(8, usuario.getEndereco());
            ps.setString(9, usuario.getImageURL());

            //usuario a ser atualizado
            ps.setLong(10,usuario.getId());

            ps.execute();
            ps.close();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("procedimento abortado." + e.getMessage());
            e.printStackTrace();
        }

    }
    public void atualizaUser(UserVendedor usuario){
        String sql = "UPDATE USUARIOS SET cpf= ?, tipo= ?,nome= ?, email= ?, senha= ?, idcarteira= ?, username = ?, imageurl= ?, ranking= ?" + "WHERE iduser = ? ";
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
            ps.setString(8, usuario.getImageURL());
            ps.setString(9, String.valueOf(usuario.getRank()));

            //usuario a ser atualizado
            ps.setLong(10,usuario.getId());
            ps.execute();
            ps.close();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("procedimento abortado." + e.getMessage());
            e.printStackTrace();
        }

    }
    public void atualizaUser(UserAdmin usuario){
        String sql = "UPDATE USUARIOS SET cpf= ?, tipo= ?,nome= ?, email= ?, senha= ?, idcarteira= ?, username = ?, imageurl=?" + "WHERE iduser = ? ";
        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            //dados
            ps.setString(1, String.valueOf(usuario.getCpf()));
            ps.setString(2, String.valueOf(usuario.getTipo()));
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            ps.setLong(6, 0);
            ps.setString(7, usuario.getUsername());
            ps.setString(8, usuario.getImageURL());

            //usuario a ser atualizado
            ps.setLong(9,usuario.getId());
            ps.execute();
            ps.close();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("procedimento abortado." + e.getMessage());
            e.printStackTrace();
        }

    }
}
