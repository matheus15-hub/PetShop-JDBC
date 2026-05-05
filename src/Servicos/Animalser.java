package Servicos;

import DAO.AnimalDAO;
import entidades.Animal;

public class Animalser {
    public void cadastrar(Animal animal){
        if(animal.getPeso() < 0){
            System.out.println("Peso nao pode ser menor que ZERO");
            return;
        }
        else if(animal.getNome() == null || animal.getNome().isEmpty()){
            System.out.println("Nome não pode estar vazio!");
            return;
        }
         new AnimalDAO().cadastrarAnimal(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }
    public void excluir(Animal animal){
        new DAO.Deletar().deletarAnimal(animal);
        System.out.println("Deletado com sucesso!");
    }
    public void listarAnimais(Animal animal){
        new DAO.ExebirDAO().ExebirInfoAnimal(animal);
    }
}
