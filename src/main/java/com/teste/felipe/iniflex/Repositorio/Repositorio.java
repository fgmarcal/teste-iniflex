package com.teste.felipe.iniflex.Repositorio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.teste.felipe.iniflex.Builders.FuncionarioBuilder;
import com.teste.felipe.iniflex.Entidades.Funcionario.Funcionario;

public class Repositorio {

    private List<Funcionario> funcionarios;
    String[][] baseDeDados;
    
    public Repositorio(List<Funcionario> funcionarios) {

        this.funcionarios = funcionarios;

        BaseDeFuncionarios base = new BaseDeFuncionarios();
        this.baseDeDados = base.dadosFuncionarios;
    }

    /**
     * @implSpec Método de geração em lote de funcionários usando Pattern Builder
     * @param funcionarios
     */

    public void addFuncionariosEmLote(List<Funcionario> funcionarios){
        this.funcionarios = funcionarios;
        for (String dados[] : this.baseDeDados) {
            funcionarios.add(new FuncionarioBuilder()
                .addNome(dados[0])
                .addDataNascimento(dados[1])
                .addSalario(new BigDecimal(dados[2]))
                .addFuncao(dados[3])
                .get());
        }
    }

    public List<Funcionario> getFuncionario(){
        return this.funcionarios;
    }

    public void removerFuncionarioPorNome(String nome){
        this.funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
    }

    public void updateSalarios(double aumentoPercentual){
        this.funcionarios.forEach(funcionario -> {
            funcionario.updateSalario(aumentoPercentual);
        });
    }

    public Map<String, List<Funcionario>> groupByFuncao(){
        Map <String, List<Funcionario>> funcoes = new HashMap<>();

        for (Funcionario funcionario : this.funcionarios){
            String funcao = funcionario.getFuncao();
            if(!funcoes.containsKey(funcao)){
                funcoes.put(funcao, new ArrayList<>());
            }
            funcoes.get(funcao).add(funcionario);
        }
        return funcoes;
    }

}
