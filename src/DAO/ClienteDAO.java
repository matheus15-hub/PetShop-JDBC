package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidades.Cliente;
//No DAO é onde que o vamos pegar as nossas informações e jogar no banco de dados
public class ClienteDAO {
    
    public void cadastrarCliente(Cliente cliente){
        //comando de sql de insert into, no ? é onde vamos receber nossos valores (ELES REPRESENTAM OS VALORES)
        String sql = "INSERT INTO cliente(NOME, TELEFONE) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            //aqui que vamos receber e colocar os dados, esse 1 significa o primeiro ? me se fosse 2 seginifica o 2 segundo ? e sucessivamente 
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());

            //executa a conexão com o banco de dados
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
