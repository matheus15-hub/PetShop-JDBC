package Exibir;

import javax.print.DocFlavor.STRING;

import conexao.Conexao;

import java.sql.Statement;
import java.sql.ResultSet;

import entidades.Animal;

public class ExebirAnimal {
    public void ExebirInfoAnimal(Animal animal){

        ResultSet resultSet = null;
        Statement statement = null;
        
       
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


        } catch (Exception e) {
            // TODO: handle exception
        }


        

    }
}
    
