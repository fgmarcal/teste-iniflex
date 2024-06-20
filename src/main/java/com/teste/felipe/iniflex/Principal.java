package com.teste.felipe.iniflex;

import java.util.ArrayList;
import java.util.List;

import com.teste.felipe.iniflex.Database.Database;
import com.teste.felipe.iniflex.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Funcionario.Imprimir;

public class Principal {
    public static void main(String[] args) {

        
        //3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela acima

        List <Funcionario> funcionarios = new ArrayList<Funcionario>();
        Database database = new Database(funcionarios);

        database.addFuncionariosEmLote(funcionarios);
        //3.2 - Remover o funcionário "João" da lista;
        database.removerFuncionarioPorNome("João");
        //3.3 - Imprimir todos os funcionários com todas suas informações, sendo que:
        /* 
            - informação de data deve ser exibida no formato dd/mm/aaaa;
            - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula;
        */
        System.out.println("\n########################### Lista de Funcionários ##########################");
        System.out.println(funcionarios);

        //3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com o novo valor;
        database.updateSalarios(10.0);

        System.out.println("\n########################### Lista de Funcionários com aumento ##########################");
        System.out.println(funcionarios);

        //3.5 - Agrupar os funcionários por função em um MAP, sendo a chave a "função" e o valor a "lista de funcionários"
        database.groupByFuncao();
        //3.6 - Imprimir os funcionarios agrupados por função;
        System.out.println("\n########################### Lista de Funcionários agrupados ##########################");
        // database.imprimirPorFuncao();
        // System.out.println("3.6");
        Imprimir imprimir = new Imprimir(funcionarios);
        imprimir.imprimirPorFuncao(database);

        //3.8 - Imprimir os funcionários que fazem aniversário do mês 10 e 12;
        System.out.println("\n");
        System.out.println("Aniversariantes dos meses 10 e 12");
        imprimir.imprimirAniversariantesMes(10, 12);

        //3.9 - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("\n");
        imprimir.imprimirFuncionarioMaisVelho();

        //3.10 - Imprimir a lista de funcionários por ordem alfabética
        System.out.println("\n");
        imprimir.imprimirFuncionariosPorOrdemAlfabetica();

        //3.11 - Imprimir o total dos salários dos funcionários
        System.out.println("\n");
        imprimir.imprimirTotalSalarios();

        //3.12 - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário
        // mínimo é de R$ 1212.00;
        System.out.println("\n");
        imprimir.imprimirSalariosMinimos();
    }
}