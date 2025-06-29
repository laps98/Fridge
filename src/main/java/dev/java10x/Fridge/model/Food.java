package dev.java10x.Fridge.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "food_table")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeValidade;
    private Integer quantidade;

    public Food() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIn() {
        return id;
    }

    public void setIn(Long id) {
        this.id = id;
    }
}
