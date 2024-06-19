package com.teste.felipe.iniflex;

import java.util.ArrayList;
import java.util.List;

import com.teste.felipe.iniflex.Database.Database;
import com.teste.felipe.iniflex.Funcionario.Funcionario;

public class Principal {
    public static void main(String[] args) {

        
        //3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela acima

        List <Funcionario> funcionarios = new ArrayList<Funcionario>();
        Database list = new Database(funcionarios);

        System.out.println("\n########################### Lista de Funcionários ##########################");
        System.out.println(funcionarios);


        //3.2 - Remover o funcionário "João" da lista;

        list.removerFuncionarioPorNome("João", funcionarios);
        
        //3.3 - Imprimir todos os funcionários com todas suas informações, sendo que:
        /* 
            - informação de data deve ser exibida no formato dd/mm/aaaa;
            - informação de valor numério deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula;
        */
        System.out.println("\n########################### Lista de Funcionários ##########################");
        System.out.println(funcionarios);

        //3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com o novo valor;
        list.updateSalarios(10, funcionarios);
        System.out.println("\n########################### Lista de Funcionários ##########################");
        System.out.println(funcionarios);









    }
}