package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import conexao.Conexao;
import entidades.Animal;
import entidades.Cliente;
import entidades.Medico;

public class ExebirDAO {
        ResultSet resultSet = null;
        Statement statement = null;
        
        //MOSTRAR ANIMAL TABELA===================================================
    public void ExebirInfoAnimal(Animal animal){
        try {
            statement = Conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM animal");
            while (resultSet.next()) {
                int id = resultSet.getInt("idAnimal");
                String nome = resultSet.getString("nome");
                String tipoanimal = resultSet.getString("tipoAnimal");
                int codC = resultSet.getInt("codCliente");
                System.out.println("Codigo:" + id +"\tNome:"+nome+"\tEspecie:"+tipoanimal+"\tDono:"+codC);
            }
        } catch (Exception e) { } }

         //MOSTRAR CLIENTE TABELA===================================================
        public void ExibirInfoCliente(Cliente cliente){
        try {
            statement = Conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cliente");

            while (resultSet.next()) {
                int id = resultSet.getInt("idCliente");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                System.out.println("ID:"+id+"\tNOME:"+nome+"\tTELEFONE:"+telefone );
            }
        } catch (Exception e) { } }

         //MOSTRAR MEDICO TABELA===================================================

         public void ExibirInfoMedico(Medico medico) {
        try {
            statement = Conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM medico");
            while (resultSet.next()) {
                int id = resultSet.getInt("idMedico");
                String nome = resultSet.getString("nome");
                String sexo = resultSet.getString("sexo");
                String crm = resultSet.getString("crm");
                String telefone = resultSet.getString("telefone");
                System.out.println("ID:"+id+"\tNOME:"+nome+"\tTELEFONE:"+telefone+"\tSEXO:"+sexo+"\tCRM:"+ crm);
            }
        } catch (Exception e) {  } }
}
