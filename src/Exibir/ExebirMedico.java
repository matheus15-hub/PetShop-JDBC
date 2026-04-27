package Exibir;

import java.sql.ResultSet;
import java.sql.Statement;
import conexao.Conexao;
import entidades.Medico;

public class ExebirMedico {
    
    public void ExibirInfoMedico(Medico medico) {
        
        ResultSet resultSet = null;
        Statement statement = null;

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


        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
