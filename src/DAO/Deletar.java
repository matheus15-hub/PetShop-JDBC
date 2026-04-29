package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexao.Conexao;
import entidades.Cliente;
import entidades.Medico;
import entidades.Animal;

public class Deletar {
    public void deletarCliente(Cliente cliente, Animal animal) {

        try {
            String sql = "DELETE FROM cliente where idCliente = ?"; 
            String sqlAninmal = "DELETE FROM animal where codCliente = ?";
            
            //primeiro deletamos o animal que esta logado com o cliente, como o animal tem uma chave estrangeira not null no campo de atrinbutos, se tentarmos apagar o cliente antes da erro.
            PreparedStatement st = Conexao.getConexao().prepareStatement(sql);
            PreparedStatement an = Conexao.getConexao().prepareStatement(sqlAninmal);
            
            an.setInt(1, animal.getCodCliente());
            st.setInt(1, cliente.getIdCliente());

            int deletan = an.executeUpdate();
            int delecot = st.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void deletarAnimal(Animal animal){
        String sql = "DELETE FROM animal where idAnimal = ?";
        try {
            PreparedStatement an = Conexao.getConexao().prepareStatement(sql);
            an.setInt(1, animal.getIdAnimal());
            int dele = an.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
    public void deletarMedicos(Medico medico){

        String sql = "DELETE FROM medico where idMedico = ?";
        try {
            PreparedStatement md = Conexao.getConexao().prepareStatement(sql);

            md.setInt(1, medico.getIdMedico());

            int dele = md.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}
