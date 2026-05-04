package Servicos;

import entidades.Cliente;

public class Clienteser {
    
    public void cadastrar(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isEmpty()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        new DAO.ClienteDAO().cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado");
    }

    public void listarClientes(){
        Cliente clientela = new Cliente();
        new DAO.ExebirDAO().ExibirInfoCliente(clientela);
    }

}
