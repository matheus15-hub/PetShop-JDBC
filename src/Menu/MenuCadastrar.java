package Menu;

import java.time.LocalDate;
import java.util.Scanner;

import Servicos.Animalser;
import Servicos.Clienteser;
import Servicos.Medicoser;
import entidades.Animal;
import entidades.Cliente;
import entidades.Medico;
import DAO.AnimalDAO;

public class MenuCadastrar {
    
    Scanner scanner = new Scanner(System.in);
    public void medicoAdd(Medico medico){
        System.out.println("\tCadastrando Medicos");

        System.out.print("Nome..");
        medico.setNome(scanner.nextLine());

        System.out.print("Telefone..");
        medico.setTelefone(scanner.nextLine());

        System.out.print("Sexo..");
        medico.setSexo(scanner.nextLine());

        System.out.print("CRM..");
        medico.setCrm(scanner.nextLine());
        
        new Medicoser().cadastrar(medico);
    }

    public void clienteAdd(Cliente cliente){
        System.out.println("\tCadastrar Cliente");

        System.out.print("Nome..");
        cliente.setNome(scanner.nextLine());

        System.out.print("Telefone..");
        cliente.setTelefone(scanner.nextLine());

        new Clienteser().cadastrar(cliente);
    }

    public void animalAdd(Animal animal){
        System.out.println("\tCadastrar Animal");

        System.out.print("Nome..");
        animal.setNome(scanner.nextLine());

        System.out.print("Data Nascimento..");
        animal.setNascimento(LocalDate.parse(scanner.nextLine()));

        System.out.print("Especie..");
        animal.setTipoAnimal(scanner.nextLine());

        System.out.print("Peso..");
        animal.setPeso(scanner.nextFloat());
        scanner.nextLine();

        int dono = selecionardono();
        animal.setCodCliente(dono);

        new Animalser().cadastrar(animal);
        
    }

    private int selecionardono(){
        System.out.print("Consultar donos cadastrados: S | N ..");
        String solicitardonosCadastraodos = scanner.nextLine();
        if (solicitardonosCadastraodos.equalsIgnoreCase("s")){
            new Clienteser().listarClientes();
        }
        System.out.print("COD Cliente..");
        int escoCodCliente = scanner.nextInt();
        return escoCodCliente;

    }

}
