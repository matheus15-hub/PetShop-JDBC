package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexao.Conexao;
import entidades.Cliente;
import entidades.Animal;

public class ClienteDel {
    public void deletarCliente(Cliente cliente, Animal animal) {
        
         

        try {
            String sql = "DELETE FROM cliente where idCliente = ?"; 
            String sqlAninmal = "DELETE FROM animal where idCliente = ?";
            
            PreparedStatement st = Conexao.getConexao().prepareStatement(sql);
            PreparedStatement an = Conexao.getConexao().prepareStatement(sqlAninmal);
            
            st.setInt(1, cliente.getIdCliente());
            an.setInt(1, animal.getCodCliente());

            int delecot = st.executeUpdate();
            int deletan = an.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    
}
