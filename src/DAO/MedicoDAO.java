package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidades.Medico;

public class MedicoDAO {

    public void cadastrarMedico(Medico medico){

        String sql = "INSERT INTO medico(nome, telefone, crm, sexo) VALUES (?,?,?,?)";

        PreparedStatement ms = null;

        try {
            ms = Conexao.getConexao().prepareStatement(sql);

            ms.setString(1, medico.getNome());
            ms.setString(2, medico.getTelefone());
            ms.setString(3, medico.getCrm());
            ms.setString(4, medico.getSexo());

            ms.execute();
            ms.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
