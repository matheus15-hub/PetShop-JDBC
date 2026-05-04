import entidades.Animal;
import entidades.Cliente;
import entidades.Consulta;
import entidades.Medico;
import DAO.AnimalDAO;
import DAO.ClienteDAO;
import DAO.MedicoDAO;
import Exibir.Apresentacao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //java FX cria uma inter

        Cliente clientela = new Cliente();
        Medico med = new Medico();
        Animal ani = new Animal();

        Scanner scanner = new Scanner(System.in);
        int cadastro;
        
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.apresentarPetShop();

        //CADASTRAR============
        if (apresentacao.getEscolha() == 1) {
            System.out.println("Deseja Cadastrar 1)Animal 2)Cliente 3)Medico");
            int escolhaCadastro = scanner.nextInt();
            switch (escolhaCadastro) {
                case 1:
                    new Menu.MenuCadastrar().animalAdd(ani);
                    break;
                case 2:
                    new Menu.MenuCadastrar().clienteAdd(clientela);
                    break;
                case 3:
                    new Menu.MenuCadastrar().medicoAdd(med);
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }


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

            //EXEBIR==================================

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

        }
        else if (apresentacao.getEscolha() == 4) {
            Apresentacao apreCOn = new Apresentacao();
            apreCOn.apresentacaoConsulta();
            if(apreCOn.getEscolha() == 1){
                System.err.println("\tNOVA CONSULTA");
                System.out.print("Data..");
                String d = scanner.nextLine();
                LocalDateTime data = LocalDateTime.parse(d);
                System.out.print("Sabe o Cod do Animal S | N..");
                String esco = scanner.nextLine();
                if(esco.equalsIgnoreCase("n")){
                    new DAO.ExebirDAO().ExebirInfoAnimal(ani);
                }
                System.out.print("COD Animal..");
                int codAnimal = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Sabe o COD do Medico S | N..");
                esco = scanner.nextLine();
                if(esco.equalsIgnoreCase("n")){
                    new DAO.ExebirDAO().ExibirInfoMedico(med);
            }
                System.out.print("COD Medico..");
                int codMedico = scanner.nextInt();
                esco = scanner.nextLine();
                System.out.print("Prescrição..");
                String precricao = scanner.nextLine();
                System.out.print("Valor..");  
                float valor = scanner.nextFloat();
                System.out.print("Adicionais..");
                float adicionais = scanner.nextFloat();
                
                Consulta con = new Consulta();
                con.setData_consulta(data);
                con.setCodAnimal(codAnimal);
                con.setCodMedico(codMedico);
                con.setPrescrissao(precricao);
                con.setPreco(valor);
                con.setAdicional(adicionais);

                new DAO.ConsultaDAO().cadastrarConsulta(con);

        }
        else{
            System.out.println("Opeção invalida!");
        }
       
        scanner.close();
    
        
        
    }
}
}