package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import conexao.Conexao;
import entidades.Animal;

public class AnimalDAO {
    public void cadastrarAnimal(Animal animal){

        String sql ="INSERT INTO animal(nome,nascimento, tipoAnimal, peso, codCliente) VALUES(?,?,?,?,?)";

        PreparedStatement ac = null;

        try {
            ac = Conexao.getConexao().prepareStatement(sql);

            ac.setString(1, animal.getNome());
            //para dar certo eu preciso converter o localDate com valueOf() mas preciso colocar a "extenção" java.sql.Date, afinal preciso mandar um Date para o banco de dados
            ac.setDate(2, java.sql.Date.valueOf(animal.getNascimento()));
            ac.setString(3, animal.getTipoAnimal());
            ac.setFloat(4, animal.getPeso());
            ac.setInt(5, animal.getCodCliente());
            
            ac.execute();
            ac.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        

    }
}