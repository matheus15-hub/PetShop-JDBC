package Menu;

import java.util.Scanner;

import Servicos.Animalser;
import Servicos.Clienteser;
import Servicos.Medicoser;
import entidades.Animal;
import entidades.Cliente;
import entidades.Medico;

public class MenuExclusao {
    Scanner scanner = new Scanner(System.in);
    public void animalExc(Animal animal){
        System.out.println("\t\tExcluindo Animal");
        new Animalser().listarAnimais(animal);
        System.out.println("Escolha um animal para excluir(ESCOLHA APARTI DO ID)");
        System.out.print("ID..");
        animal.setIdAnimal(scanner.nextInt());
        new Animalser().excluir(animal);
        new Animalser().listarAnimais(animal);

    }

    public void clienteExc(Cliente cliente, Animal animal){
        System.out.println("\t\tExcluindo Cliente");
        new Clienteser().listarClientes();
        System.out.println("Escolha um Cliente para excluir(ESCOLHA APARTI DO ID)");
        System.out.print("ID..");
        int cod = scanner.nextInt();
        animal.setCodCliente(cod);
        cliente.setIdCliente(cod);
        new Clienteser().excluir(cliente, animal);
        new Clienteser().listarClientes();
    }

    public void medicoExc(Medico medico){
        System.out.println("\tExcluindo Medico");
        new Medicoser().listarMedico();
        System.out.println("Escolha um Medico para excluir(ESCOLHA APARTI DO ID)");
        System.out.print("ID..");
        medico.setIdMedico(scanner.nextInt());
        new Medicoser().excluir(medico);
        new Medicoser().listarMedico();
    }
}
