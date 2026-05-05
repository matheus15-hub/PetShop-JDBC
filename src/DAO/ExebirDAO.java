package DAO;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import conexao.Conexao;
import entidades.Animal;
import entidades.Cliente;
import entidades.Consulta;
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
        public void BuscarMedico(Medico medico){
            String sql = "SELECT * FROM medico where nome like  ?";
            try {
                PreparedStatement md = Conexao.getConexao().prepareStatement(sql);
                md.setString(1, medico.getNome() + "%");
                resultSet = md.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("idMedico");
                    String nome = resultSet.getString("nome");
                    String sexo = resultSet.getString("sexo");
                    String crm = resultSet.getString("crm");
                    String telefone = resultSet.getString("telefone");
                    System.out.println("ID:"+id+"\tNOME:"+nome+"\tTELEFONE:"+telefone+"\tSEXO:"+sexo+"\tCRM:"+ crm);
                }
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public void ExibirinfoConsulta(Consulta consulta){
            String sql = "SELECT c.idConsulta, c.data_consulta, c.prescrissao, c.preco, c.adicional, " +
             "a.nome AS nomeAnimal, m.nome AS nomeMedico " +
             "FROM consulta c " +
             "JOIN animal a ON c.codAnimal = a.idAnimal " +
             "JOIN medico m ON c.codMedico = m.idMedico";
            try {
                statement = Conexao.getConexao().createStatement();
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    
                    int id = resultSet.getInt("idConsulta");

                    LocalDateTime dataConsulta = resultSet
                            .getTimestamp("data_consulta")
                            .toLocalDateTime();

                    String nomeAnimal = resultSet.getString("nomeAnimal");
                    String nomeMedico = resultSet.getString("nomeMedico");
                    String prescrissao = resultSet.getString("prescrissao");

                    float preco = resultSet.getFloat("preco");
                    float adicional = resultSet.getFloat("adicional");
                    float total = preco + adicional;

                    linha();
                    System.out.println("||\t\t\t\tCONSULTA: N°" + id);
                    linha();
                    System.out.print("||DATA: " + dataConsulta);
                    System.out.print("\tANIMAL: " + nomeAnimal);
                    System.out.println("\tMEDICO: " + nomeMedico);
                    linha();
                    System.out.println("||PRESCRISSAO: " + prescrissao+ "\n||");
                    linha();
                    System.out.print("||PREÇO: R$" + preco);
                    System.out.print("\tADICIONAL: R$" + adicional);
                    System.out.println("\tTOTAL: R$" + total);
                    linha();
                    System.out.println("\n");
                }
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void linha(){
            System.out.println("||============================================================================================");
        }
}
