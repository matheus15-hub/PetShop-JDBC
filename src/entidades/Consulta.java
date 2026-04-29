package entidades;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta;
    private LocalDateTime data_consulta;
    private float preco;
    private float adicional;
    private String prescrissao;
    private int codAnimal;
    private int codMedico;

    public int getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDateTime getData_consulta() {
        return data_consulta;
    }
    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }

    public float getAdicional() {
        return adicional;
    }
    public void setAdicional(float adicional) {
        this.adicional = adicional;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getPrescrissao() {
        return prescrissao;
    }
    public void setPrescrissao(String prescrissao) {
        this.prescrissao = prescrissao;
    }

    public int getCodAnimal() {
        return codAnimal;
    }
    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public int getCodMedico() {
        return codMedico;
    }
    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }
}
