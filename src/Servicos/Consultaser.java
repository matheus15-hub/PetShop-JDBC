package Servicos;

import entidades.Consulta;

public class Consultaser {

    public void cadastrar(Consulta consulta){
        new DAO.ConsultaDAO().cadastrarConsulta(consulta);
        System.out.println("Marcado!");
    }
    public void listarConsultas(){
        Consulta consulta = new Consulta();
        new DAO.ExebirDAO().ExibirinfoConsulta(consulta);
    }
}
