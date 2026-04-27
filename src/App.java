import entidades.Animal;
import entidades.Cliente;
import entidades.Medico;
import DAO.AnimalDAO;
import DAO.ClienteDAO;
import DAO.MedicoDAO;
import Exibir.Apresentacao;
import Exibir.ExebirAnimal;
import Exibir.ExebirCliente;
import Exibir.ExebirMedico;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Cliente clientela = new Cliente();
        Medico med = new Medico();
        Animal ani = new Animal();

        Scanner scanner = new Scanner(System.in);
        int cadastro;
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.apresentarPetShop();

        if (apresentacao.getEscolha() == 1) {
            String nome;
            String telefone;
            String crm;
            String sexo;
            LocalDate nascimento;
            float peso;
            String tipoAnimal;
            int dono;

            System.out.println("Deseja cadastrar 1)Cliente , 2)Medico 3)Animal ::");
            cadastro = scanner.nextInt();
            scanner.nextLine();

            if(cadastro == 1){  
            System.out.print("Nome do Dono do Pet: ");
            nome = scanner.nextLine();

            System.out.print("Telefone: ");
            telefone = scanner.nextLine();

            clientela.setNome(nome);
            clientela.setTelefone(telefone);

            new ClienteDAO().cadastrarCliente(clientela);

            System.out.println(" Cadastrado!");
        }

        else if(cadastro == 2){
            System.out.print("Nome:");
            nome = scanner.nextLine();

            System.out.print("Telefone:");
            telefone = scanner.nextLine();

            System.out.print("CRM:");
            crm = scanner.nextLine();

            System.out.print("Sexo | M para masculino | F para feminino :");
            sexo = scanner.nextLine();

            med.setNome(nome);
            med.setTelefone(telefone);
            med.setCrm(crm);
            med.setSexo(sexo);
            
            new MedicoDAO().cadastrarMedico(med);
        }else if(cadastro == 3){
            System.out.print("Nome do Animal.......");
            nome = scanner.nextLine();
            System.out.print("Data Nascimento......");
            String data = scanner.nextLine();
            nascimento = LocalDate.parse(data);
            System.out.print("Tipo Animal..........");
            tipoAnimal = scanner.nextLine();
            System.out.print("Peso.................");
            peso = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Conlutar Donos Cadastrados: S | N........");
            String esc = scanner.nextLine();
            if(esc.equalsIgnoreCase("S")){
                new ExebirCliente().ExibirInfoCliente(clientela);
            }
            System.out.print("Dono.................");
            dono = scanner.nextInt();

            ani.setNome(nome);
            ani.setNascimento(nascimento);
            ani.setTipoAnimal(tipoAnimal);
            ani.setPeso(peso);
            ani.setCodCliente(dono);
            
            new AnimalDAO().cadastrarAnimal(ani);
            System.out.println("Animal Cadastrado");
            new ExebirAnimal().ExebirInfoAnimal(ani);
        }

        }else if (apresentacao.getEscolha() == 2) {
            
        }else if (apresentacao.getEscolha() == 3) {
            System.out.println("================================================================");
            System.out.println("Consultar. 1)Cliente 2)Animal 3)Medico");
            System.out.print("Escolha:");
            int esc = scanner.nextInt();
            scanner.nextLine();
            switch(esc){
                case 1:
                    new ExebirCliente().ExibirInfoCliente(clientela);
                    break;
                case 2:
                    new ExebirAnimal().ExebirInfoAnimal(ani);
                    break;
                case 3:
                    new ExebirMedico().ExibirInfoMedico(med);
                    break;
                default:
                    System.out.println("Opeção Invalida!");
                    break;
                    
            }

        }else{
            System.out.println("Opeção invalida!");
        }
        
        
        
        scanner.close();
    }
}