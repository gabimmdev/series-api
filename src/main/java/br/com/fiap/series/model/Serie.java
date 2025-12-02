package br.com.fiap.series.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da série não pode ser vazio.")
    private String nome;

    @NotBlank(message = "O gênero não pode ser vazio.")
    private String genero;

    @Min(value = 1900, message = "Ano inválido.")
    private int anoLancamento;

    @Positive(message = "A quantidade de temporadas deve ser positiva.")
    private int temporadas;

    @Pattern(
        regexp = "Livre|12\\+|16\\+|18\\+",
        message = "Classificação deve ser: Livre, 12+, 16+ ou 18+."
    )
    private String classificacao;

    public Serie() {}

    public Serie(String nome, String genero, int anoLancamento, int temporadas, String classificacao) {
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.temporadas = temporadas;
        this.classificacao = classificacao;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
