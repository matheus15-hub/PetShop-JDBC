package Servicos;

import entidades.Medico;

public class Medicoser {
    public void cadastrar(Medico medico){
        new DAO.MedicoDAO().cadastrarMedico(medico);
        System.out.println("Medico Cadastrado");
    }
    public void listarMedico(){
        Medico medico = new Medico();
        new DAO.ExebirDAO().ExibirInfoMedico(medico);
    }
}
