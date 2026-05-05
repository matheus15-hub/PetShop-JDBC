package Servicos;

import java.util.Scanner;

import entidades.Animal;
import entidades.Cliente;

public class Clienteser {
    Scanner scanner = new Scanner(System.in);
    public void cadastrar(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isEmpty()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        new DAO.ClienteDAO().cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado");
    }

    public boolean decisao(){
        System.out.println("Deseja mesmo excluir esse cliente, sera apagado junto a ele \ntodos os animas que tem ele como dono:S | N");
        System.out.print("Certeza..");
        String decisao = scanner.nextLine();
        if(decisao.equalsIgnoreCase("s")){return true;}
        else{return false;}
    }

    public void excluir(Cliente cliente , Animal animal){
        if (decisao()) {
            new DAO.Deletar().deletarCliente(cliente , animal);
            System.out.println("Cliente apagado");
        }else{System.out.println("Opreção cancelada!");}
    }

    public void listarClientes(){
        Cliente clientela = new Cliente();
        new DAO.ExebirDAO().ExibirInfoCliente(clientela);
    }

}
