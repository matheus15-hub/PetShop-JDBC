package Exibir;

import java.util.Scanner;

public class Apresentacao {

    private int escolha;
    Scanner scanner = new Scanner(System.in);
    public void apresentarPetShop(){
        System.out.println("\t \tBem Vindo ao PetShop Alfa");
        System.out.println("================================================================");
        System.out.println("\tO Melhor Atendimento que você e seu pet merece!");
       System.out.println("\nComo podemos te ajudar: 1)Adicionar 2)Excluir 3)Exebir 4)Consultas 5)Sair");
       int num = scanner.nextInt();
       setEscolha(num);
    }


    public void apresentacaoConsulta(){
        System.out.println("================================================================");
        System.out.println("1)Adicionar 2)Buscar");
        int num = scanner.nextInt();
        setEscolha(num);
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }
    public int getEscolha() {
        return escolha;
    }



}
