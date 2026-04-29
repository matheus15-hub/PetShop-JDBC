package DAO;


import conexao.Conexao;
import entidades.Consulta;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {
    public void cadastrarConsulta(Consulta consulta){
        String sql = "INSERT INTO consulta(data_consulta, prescrissao , preco, adicional, codAnimal, codMedico) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement cc = Conexao.getConexao().prepareStatement(sql);
            cc.setTimestamp(1, java.sql.Timestamp.valueOf( consulta.getData_consulta()));
            cc.setString(2, consulta.getPrescrissao());
            cc.setFloat(3, consulta.getPreco());
            cc.setFloat(4, consulta.getAdicional());
            cc.setInt(5, consulta.getCodAnimal());
            cc.setInt(6, consulta.getCodMedico());

            cc.execute();
            cc.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
