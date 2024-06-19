package com.teste.felipe.iniflex.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
    
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(){}
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    private LocalDate formatarDataNascimentoLocalDate(String dataNascimento) {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataNascimento, formatarData);
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = formatarDataNascimentoLocalDate(dataNascimento);
    }

    public String printDataNascimento() {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatada = getDataNascimento().format(formatarData);
        return dataNascimentoFormatada;
    }
    
}
