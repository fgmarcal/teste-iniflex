package com.teste.felipe.iniflex.Database;

import java.math.BigDecimal;
import java.util.List;

import com.teste.felipe.iniflex.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Funcionario.FuncionarioBuilder;

public class Database {
    
    BaseDeFuncionarios base = new BaseDeFuncionarios(); 

    public Database(List<Funcionario> list) {

        List<Funcionario> funcionarios = list;

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

    public void removerFuncionarioPorNome(String nome, List<Funcionario> funcionarios){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
    }

    public void updateSalarios(int aumento, List<Funcionario> funcionarios){
        funcionarios.forEach(funcionario -> {
            funcionario.updateSalario(aumento);
        });
    }
}
