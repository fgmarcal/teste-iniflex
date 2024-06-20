package com.teste.felipe.iniflex.Entidades.Pessoa;

import java.time.LocalDate;
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
        var dataFormatada = new FormatarData().formatarDataStringParaLocalDate(dataNascimento);
        this.dataNascimento = dataFormatada;
    }

    public String printDataNascimento() {
        var dataNascimentoFormatada = new FormatarData().formatarDataLocalDateParaString(getDataNascimento());
        return dataNascimentoFormatada;
    }
    
}
