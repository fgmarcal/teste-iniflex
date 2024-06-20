package com.teste.felipe.iniflex.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.teste.felipe.iniflex.Utils.FormatarData;

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

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        var dataFormatada = new FormatarData().formatarDataLocalDate(dataNascimento);
        this.dataNascimento = dataFormatada;
    }

    public String printDataNascimento() {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatada = getDataNascimento().format(formatarData);
        return dataNascimentoFormatada;
    }
    
}
