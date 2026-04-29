import entidades.Animal;
import entidades.Cliente;
import entidades.Medico;
import DAO.AnimalDAO;
import DAO.ClienteDAO;
import DAO.MedicoDAO;
import Exibir.Apresentacao;
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

        //CADASTRAR============
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
                new DAO.ExebirDAO().ExibirInfoCliente(clientela);
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
            new DAO.ExebirDAO().ExebirInfoAnimal(ani);
        }

        //EXCLUIR=======================================

        }else if (apresentacao.getEscolha() == 2) {

            System.out.println("Deseja excluir:1)Animal, 2)Cliente, 3)Medico");
            System.out.print("Escolha:");
            int esc = scanner.nextInt();
            if(esc == 1){
                System.err.println("\nAnimais Cadastrados");
                new DAO.ExebirDAO().ExebirInfoAnimal(ani);
                System.err.println("=========================================");
                System.out.println("Escolha algum animal para excluir apartir do ID dele");
                System.out.print("Escolha::");
                esc = scanner.nextInt();
                ani.setIdAnimal(esc);
                new DAO.Deletar().deletarAnimal(ani);
                new DAO.ExebirDAO().ExebirInfoAnimal(ani);

            }
            else if(esc == 2){

                new DAO.ExebirDAO().ExibirInfoCliente(clientela);
                System.out.println("=====================================\nEscolha um cadastro para apagar pelo ID");
                System.out.print("Escolha:");
                esc = scanner.nextInt();
                ani.setCodCliente(esc);
                clientela.setIdCliente(esc);
                new DAO.Deletar().deletarCliente(clientela , ani );;
                
                new DAO.ExebirDAO().ExibirInfoCliente(clientela);
            }
            else if(esc == 3){
                
               System.out.println("------------------------------------------");
               System.out.println("Escolha um medico para vc deletar usando o 'ID' dele \n");
               new DAO.ExebirDAO().ExibirInfoMedico(med);
               System.out.print("ID::");
                esc = scanner.nextInt();
               med.setIdMedico(esc);
               new DAO.Deletar().deletarMedicos(med);
               new DAO.ExebirDAO().ExibirInfoMedico(med);

            }
            else{
                System.out.println("Opção invalida");
            }

            //CONSULTAR==================================

        }else if (apresentacao.getEscolha() == 3) {
            System.out.println("================================================================");
            System.out.println("Consultar: 1)Todos os Dados  2)Apenas Um");
            System.out.print("::");
            int esc = scanner.nextInt();
            scanner.nextLine();
            if(esc == 1){

                System.out.println("Consultar. 1)Cliente 2)Animal 3)Medico");
                System.out.print("Escolha:");
                esc = scanner.nextInt();
                scanner.nextLine();
                switch(esc){
                    case 1:
                        new DAO.ExebirDAO().ExibirInfoCliente(clientela);
                        break;
                        case 2:
                            new DAO.ExebirDAO().ExebirInfoAnimal(ani);
                            break;
                            case 3:
                                new DAO.ExebirDAO().ExibirInfoMedico(med);
                                break;
                                default:
                                    System.out.println("Opeção Invalida!");
                                    break;
                                    
                                }
                            }
            else if(esc == 2){
                System.out.print("Digite o nome:");
                String nome = scanner.nextLine();
                med.setNome(nome);
                new DAO.ExebirDAO().BuscarMedico(med);
            }

        }else{
            System.out.println("Opeção invalida!");
        }
       
        scanner.close();
    
        
        
    }
}