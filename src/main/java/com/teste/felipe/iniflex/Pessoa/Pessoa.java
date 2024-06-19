package com.teste.felipe.iniflex.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
    
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        String dataNascimentoFormatada = dataNascimento.format(formatarData);
        return dataNascimentoFormatada;
    }

    public void setDataNascimento(String dataNascimento) {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento, formatarData);
    }
    
}
