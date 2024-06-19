package com.teste.felipe.iniflex.Database;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void imprimirPorFuncao(){
        Map<String, List<Funcionario>> mapa = groupByFuncao();
        for(String func : mapa.keySet()){
            System.out.println("Função: " + func);
            for(Funcionario f : mapa.get(func)){
                System.out.println(f);
            }
        }
    }

    public void imprimirAniversariantesMes(int... meses) {
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesAniversario == mes) {
                    System.out.println(funcionario);
                    break;
                }
            }
        }
    }

    public void imprimirFuncionarioMaisVelho() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário na lista.");
            return;
        }

        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionario;
            }
        }

        int idade = maisVelho.getIdade();
        System.out.println("Funcionário com a maior idade:");
        System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade + " anos");
    }

    public void imprimirFuncionariosPorOrdemAlfabetica() {
        List<Funcionario> sortedList = new ArrayList<>(funcionarios);
        Collections.sort(sortedList, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario funcionario1, Funcionario funcionario2) {
                return funcionario1.getNome().compareTo(funcionario2.getNome());
            }
        });

        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario f : sortedList) {
            System.out.println(f);
        }
    }

    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        DecimalFormat formatador = new DecimalFormat("#,###.00");
        var resultado = formatador.format(totalSalarios);
        System.out.println("Total dos salários: " + resultado);
    }


}
