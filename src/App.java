import entidades.Animal;
import entidades.Cliente;
import entidades.Consulta;
import entidades.Medico;
import DAO.AnimalDAO;
import DAO.ClienteDAO;
import DAO.MedicoDAO;
import Exibir.Apresentacao;
import Menu.MenuCadastrar;
import Menu.MenuExclusao;
import Menu.MenuExibir;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {

        //java FX cria uma inter

        Cliente clientela = new Cliente();
        Medico med = new Medico();
        Animal ani = new Animal();
        Consulta consulta = new Consulta();

        int cadastro;
        
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.apresentarPetShop();

        //CADASTRAR============
        if (apresentacao.getEscolha() == 1) {
            System.out.println("Deseja Cadastrar 1)Animal 2)Cliente 3)Medico 4)Voltar");
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

            //EXCLUIR==============================
        }else if (apresentacao.getEscolha() == 2) {

            System.out.println("Deseja excluir:1)Animal, 2)Cliente, 3)Medico");
            System.out.print("Escolha:");
            int esc = scanner.nextInt();
            switch (esc) {
                case 1:
                    new MenuExclusao().animalExc(ani);
                    break;
                case 2:
                    new MenuExclusao().clienteExc(clientela, ani);
                    break;
                case 3:
                    new MenuExclusao().medicoExc(med);
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
            //EXEBIR==================================

        }else if (apresentacao.getEscolha() == 3) {
            System.out.println("================================================================");
            System.out.println("Consultar: 1)Animal, 2)Cliente, 3)Medico");
            System.out.print("::");
            int esc = scanner.nextInt();
            scanner.nextLine();
            switch (esc) {
                case 1:
                    new MenuExibir().animalMs(ani);
                    break;
                case 2:
                    new MenuExibir().clienteMs(clientela);
                    break;
                case 3:
                    new MenuExibir().medicoMs(med);
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        }
        else if (apresentacao.getEscolha() == 4) {
            System.out.println("\t\tCONSULTA!");
            System.out.println("Dejesa: 1)Marcar Consulta 2)Buscar Consultar");
            System.out.print("..");
            int escolhaConsulta = scanner.nextInt();
            switch (escolhaConsulta) {
                case 1:
                    new MenuCadastrar().consultaAdd(consulta);
                    break;
                case 2:
                    new MenuExibir().consultaMs(consulta);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }else if(apresentacao.getEscolha() == 5){break;}
        else{System.out.println("Opção Invalida");}
        System.out.println("\n\nDeseja Finalizar o programa? S | N");
        String finalizarP = scanner.nextLine();
        if(finalizarP.equalsIgnoreCase("s")){break;}
        scanner.nextLine();
    }
    System.out.println("Sistema Finalizado");
    scanner.close();
}
}