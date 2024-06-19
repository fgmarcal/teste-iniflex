package com.teste.felipe.iniflex.Funcionario;

import java.math.BigDecimal;

public class FuncionarioBuilder {
    
    private Funcionario funcionario;

    public FuncionarioBuilder(){
        this.funcionario = new Funcionario();
    }

    public static FuncionarioBuilder builder(){
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder addNome(String nome){
        this.funcionario.setNome(nome);
        return this;
    }

    public FuncionarioBuilder addDataNascimento(String data){
        this.funcionario.setDataNascimento(data);
        return this;
    }

    public FuncionarioBuilder addFuncao(String funcao){
        this.funcionario.setFuncao(funcao);
        return this;
    }

    public FuncionarioBuilder addSalario(BigDecimal salario){
        this.funcionario.setSalario(salario);
        return this;
    }

    public Funcionario get(){
        return this.funcionario;
    }
}
