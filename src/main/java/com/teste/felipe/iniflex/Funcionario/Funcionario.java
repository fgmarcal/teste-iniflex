package com.teste.felipe.iniflex.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.teste.felipe.iniflex.Pessoa.Pessoa;

public class Funcionario extends Pessoa {


    private BigDecimal salario;
    private String funcao;

    public Funcionario(){}
    
    private BigDecimal getSalario() {
        return this.salario;
    }

    private void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String printSalario(){
        DecimalFormat formatador = new DecimalFormat("#.###,00");
        return formatador.format(getSalario());
    }

    public void updateSalario(int aumento){
        var novoSalario = getSalario().multiply(new BigDecimal(1 + aumento/100));
        setSalario(novoSalario);
    }

    @Override
    public String toString() {
        return "Funcionario [Nome: " + getNome() + ", Data de Nascimento: " + printDataNascimento() + ", Função: "
                + getFuncao() + ", Salário: " + printSalario() + "]";
    }
}
