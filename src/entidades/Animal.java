package entidades;
//tem que importa isso para pode usar o Localdate, tambem posso utlizar o Datetime
import java.time.LocalDate;

public class Animal {
    private int idAnimal;
    private String nome;
    // estou usando o LocalDate pois é a variavel de da mesmo bug e ela pega apenas a idade que eu preciso
    private LocalDate nascimento;
    private String tipoAnimal;
    private float peso;
    private int codCliente;

    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
}
