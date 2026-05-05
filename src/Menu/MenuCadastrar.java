package Menu;

import java.time.LocalDate;
import java.util.Scanner;

import Servicos.Animalser;
import Servicos.Clienteser;
import Servicos.Consultaser;
import Servicos.Medicoser;
import entidades.Animal;
import entidades.Cliente;
import entidades.Consulta;
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
        
        new Medicoser().cadastrar(medico);;
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
        animal.setNascimento(scanner.nextLine());

        System.out.print("Especie..");
        animal.setTipoAnimal(scanner.nextLine());

        System.out.print("Peso..");
        animal.setPeso(scanner.nextFloat());
        scanner.nextLine();

        int dono = selecionardono();
        animal.setCodCliente(dono);

        new Animalser().cadastrar(animal);
        
    }
    
    public void consultaAdd(Consulta consulta){
        System.out.println("\t\tNova Consulta");
        System.out.print("Data..");
        String data = scanner.nextLine();
        System.out.print("Hora..");
        String hora = scanner.nextLine();
        System.out.print("Minutos..");
        String minutos = scanner.nextLine();
        consulta.setData_consulta(data , hora , minutos);
        int animalc = selecionarAnimal();
        consulta.setCodAnimal(animalc);
        scanner.nextLine();
        int medicoc = selecionarMedico();
        consulta.setCodMedico(medicoc);
        scanner.nextLine();
        System.out.print("Prescrição..");
        consulta.setPrescrissao(scanner.nextLine());
        System.out.print("Adicionais..");
        consulta.setAdicional(scanner.nextFloat());
        System.out.print("Preço..");
        consulta.setPreco(scanner.nextFloat());
        new Consultaser().cadastrar(consulta);

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
    private int selecionarMedico(){
        System.out.print("Consultar Medico: S | N..");
        String solicitarMedicos = scanner.nextLine();
        if(solicitarMedicos.equalsIgnoreCase("S")){
            new Medicoser().listarMedico();
        }
        System.out.print("\nCOD Medico..");
        int escolhetCodMedico = scanner.nextInt();
        return escolhetCodMedico;
    }
    private int selecionarAnimal(){
        Animal animal = new Animal();
        System.out.print("Consultar Animal: S | N..");
        String solicitarAnimal = scanner.nextLine();
        if(solicitarAnimal.equalsIgnoreCase("S")){
            new Animalser().listarAnimais(animal);
        }
        System.out.print("\nCOD Animal..");
        int escolherAnimal = scanner.nextInt();
        return escolherAnimal;
    }

}
