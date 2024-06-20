package com.teste.felipe.iniflex.Entidades.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import com.teste.felipe.iniflex.Entidades.Pessoa.Pessoa;
import com.teste.felipe.iniflex.Utils.FormatarValor;

public class Funcionario extends Pessoa {


    private BigDecimal salario;
    private String funcao;

    public Funcionario(){}
    
    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String printSalario(){
        var resultado = new FormatarValor().formatar(getSalario());
        return resultado;
    }

    public void updateSalario(double aumentoPercentual){
        double salario = getSalario().doubleValue();
        var novoSalario = salario*(1 + aumentoPercentual/100);
        setSalario(new BigDecimal(novoSalario));
    }

    public int getIdade(){
        return Period.between(getDataNascimento(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "\n" + "Nome: " + getNome() + ", Data de Nascimento: " + printDataNascimento() + ", Função: "
                + getFuncao() + ", Salário: " + printSalario() + "\n";
    }
}
