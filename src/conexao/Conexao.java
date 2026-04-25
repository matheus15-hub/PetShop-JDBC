package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //definição do local do banco de dados,sempre começamos com "jdbc:mysql:" pois estamos utilizando esse tipo de banco de dados, logo em seguida "//localhost:" pois estamos em banco de dados local, porta "3306" que é o padrao, e por fim colacamos o nome do nosso banco de dados"/petShop" exatamente igual ao que esta no mysql
    private static final String url = "jdbc:mysql://localhost:3306/petShop";
    //o user que vc deixou quando instalou, padrão ele deixa o root
    private static final String user ="root";
    // e a senha que por padrão é vazia
    private static final  String senha="";

    //criando a conexão com o banco de dados
    private static Connection conn;

    //metodo se a conexão ja foi instanciada ou nao
    public static Connection getConexao(){
        //try ve se vai tar algum erro de conexão
        //Conexão boa pois se nao tiver um banco de dados ela se conecta a um e se tiver ele so reaproveita
        try {
              //se a conexao nao existir (null)
             if(conn == null){
            //Sempre usar arquivos .javasql
                conn = DriverManager.getConnection(url,user,senha); //CONEXÃO COM O BANCO DE DADOS
                return conn;
            }else{
                return conn;
            }

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
        }
    }
    
}
