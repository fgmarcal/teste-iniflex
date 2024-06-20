package com.teste.felipe.iniflex.Repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teste.felipe.iniflex.Entidades.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Utils.FormatarValor;

public class RepositorioTest {
    
    private Repositorio repositorio;
    private List<Funcionario> funcionarios;

    @BeforeEach
    public void setUp() {
        funcionarios = new ArrayList<>();
        repositorio = new Repositorio(funcionarios);
    }

    @Test
    public void deveAdicionarFuncionariosEmLoteIguaisABaseDeDados() {
        var tester = funcionarios;

        repositorio.addFuncionariosEmLote(tester);

        assertEquals(repositorio.baseDeDados.length, tester.size());
        assertEquals(tester.get(0), repositorio.getFuncionarios().get(0));
    }

    @Test
    public void deveRemoverFuncionarioPorNome() {
        var tester = funcionarios;
        repositorio.addFuncionariosEmLote(tester);

        var nomeParaRemover = tester.get(0).toString();
        repositorio.removerFuncionarioPorNome(nomeParaRemover);
        
        List<Funcionario> result = repositorio.getFuncionarios();
        
        assertTrue(result.stream().noneMatch(funcionario -> 
                funcionario
                    .getNome()
                    .equals(nomeParaRemover)));        
    }

    @Test
    public void deveAumentarOSalarioPercentualmenteConformeOValorInformado() {
        var tester = funcionarios;
        double aumentoPercentual = 20.0;

        repositorio.addFuncionariosEmLote(tester);

        Funcionario funcionarioTeste = tester.get(0);
        var salarioInicial = funcionarioTeste.getSalario();
        BigDecimal salarioEsperado = salarioInicial.multiply(BigDecimal.valueOf(1 + aumentoPercentual / 100));

        repositorio.updateSalarios(aumentoPercentual);

        List<Funcionario> funcionariosComSalarioAumentado = repositorio.getFuncionarios();
        var resultado = funcionariosComSalarioAumentado.get(0);
        var funcionarioTestado = resultado.getSalario();

        var resultadoEsperado = new FormatarValor().formatar(salarioEsperado);
        var resultadoTestado = new FormatarValor().formatar(funcionarioTestado);

        assertEquals(resultadoEsperado,resultadoTestado);
        
    }

    @Test
    public void deveAgruparOsFuncionariosPorCargoOuFuncao() {
        var tester = funcionarios;
        repositorio.addFuncionariosEmLote(tester);

        Map<String, List<Funcionario>> result = repositorio.groupByFuncao();
        var funcaoTest = tester.get(0).getFuncao();
        var funcao = result.containsKey(funcaoTest);

        assertTrue(funcao);
    }

}
