package com.teste.felipe.iniflex;

import java.math.BigDecimal;

import com.teste.felipe.iniflex.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Funcionario.FuncionarioBuilder;

public class Principal {
    public static void main(String[] args) {

        Funcionario funcionario = new FuncionarioBuilder()
            .addNome("Felipe")
            .addDataNascimento("23/06/1986")
            .addFuncao("Programador")
            .addSalario(new BigDecimal(5000.00))
            .get();

        System.out.println(funcionario);






    }
}