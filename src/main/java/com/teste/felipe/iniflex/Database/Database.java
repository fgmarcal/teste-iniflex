package com.teste.felipe.iniflex.Database;

import java.math.BigDecimal;
import java.util.List;

import com.teste.felipe.iniflex.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Funcionario.FuncionarioBuilder;

public class Database {

    private List<Funcionario> funcionarios;
    
    public Database(List<Funcionario> funcionarios) {

        this.funcionarios = funcionarios;
        BaseDeFuncionarios base = new BaseDeFuncionarios();

        String[][] baseDeDados = base.dadosFuncionarios;

        for (String dados[] : baseDeDados) {
            funcionarios.add(new FuncionarioBuilder()
                .addNome(dados[0])
                .addDataNascimento(dados[1])
                .addSalario(new BigDecimal(dados[2]))
                .addFuncao(dados[3])
                .get());
        }
    }

    public void removerFuncionarioPorNome(String nome){
        this.funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
    }

    public void updateSalarios(double aumento){
        this.funcionarios.forEach(funcionario -> {
            funcionario.updateSalario(aumento);
        });
    }
}
