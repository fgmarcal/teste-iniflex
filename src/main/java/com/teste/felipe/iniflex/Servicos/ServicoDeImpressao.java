package com.teste.felipe.iniflex.Servicos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.teste.felipe.iniflex.Entidades.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Repositorio.Repositorio;
import com.teste.felipe.iniflex.Utils.FormatarValor;
import com.teste.felipe.iniflex.Utils.SalarioMinimo;

public class ServicoDeImpressao {

    private Repositorio database;

    public ServicoDeImpressao(Repositorio database){
            this.database = database;
        }

    public void imprimirPorFuncao(){
        Map<String, List<Funcionario>> mapa = database.groupByFuncao();
        for(String func : mapa.keySet()){
            System.out.println("Função: " + func);
            for(Funcionario f : mapa.get(func)){
                System.out.println(f);
            }
        }
    }

    public void imprimirAniversariantesMes(int... meses) {
        var funcionarios = database.getFuncionarios();
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
        var funcionarios = database.getFuncionarios();
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
        var funcionarios = database.getFuncionarios();
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
        var funcionarios = database.getFuncionarios();
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        var resultado = new FormatarValor().formatar(totalSalarios);
        System.out.println("Total dos salários: " + resultado);
    }


    public void imprimirSalariosMinimos() {
        var funcionarios = database.getFuncionarios();
        BigDecimal salarioMinimo = SalarioMinimo.getInstance().getValor();
        System.out.println("Quantidade de salários mínimos que cada funcionário ganha:");
        for (Funcionario f : funcionarios) {
            BigDecimal quantidadeSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_EVEN);
            var resultado = new FormatarValor().formatar(quantidadeSalariosMinimos);
            System.out.println(f.getNome() + ": " + resultado + " salários mínimos");
        }
    }
    
}
