package Exibir;

import entidades.Cliente;
import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.Statement;


public class ExebirCliente {
    public void ExibirInfoCliente(Cliente cliente){
        
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = Conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cliente");

            while (resultSet.next()) {
                int id = resultSet.getInt("idCliente");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");

                System.out.println("ID:"+id+"\tNOME:"+nome+"\tTELEFONE:"+telefone );
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
