package com.teste.felipe.iniflex.Repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teste.felipe.iniflex.Entidades.Funcionario.Funcionario;

public class RepositorioTest {
    
    private Repositorio repositorio;
    private List<Funcionario> funcionarios;

    @BeforeEach
    public void setUp() {
        funcionarios = new ArrayList<>();
        repositorio = new Repositorio(funcionarios);
    }

    @Test
    public void deveAdicionarFuncionariosEmLote() {
        repositorio.addFuncionariosEmLote(new ArrayList<>());
        List<Funcionario> result = repositorio.getFuncionario();
        
        assertEquals(repositorio.baseDeDados.length, result.size());
        
        for (int i = 0; i < repositorio.baseDeDados.length; i++) {
            String[] dados = repositorio.baseDeDados[i];
            Funcionario funcionario = result.get(i);
            
            assertEquals(dados[0], funcionario.getNome());
            assertEquals(dados[3], funcionario.getFuncao());
        }
    }

    @Test
    public void deveRemoverFuncionarioPorNome() {
        repositorio.addFuncionariosEmLote(new ArrayList<>());

        for (String[] dados : repositorio.baseDeDados) {
            String nomeParaRemover = dados[0];
            repositorio.removerFuncionarioPorNome(nomeParaRemover);
            
            List<Funcionario> result = repositorio.getFuncionario();
            
            assertTrue(result.stream().noneMatch(funcionario -> funcionario.getNome().equals(nomeParaRemover)));

            assertEquals(repositorio.baseDeDados.length - 1, result.size());

            repositorio.addFuncionariosEmLote(new ArrayList<>());
        }
    }

    @Test
    public void deveAumentarOSalarioPercentualmenteConformeOValorInformado() {
        repositorio.addFuncionariosEmLote(new ArrayList<>());
        
        double aumentoPercentual = 10.0;
        repositorio.updateSalarios(aumentoPercentual);
        List<Funcionario> result = repositorio.getFuncionario();

        for (String[] dados : repositorio.baseDeDados) {
            BigDecimal salarioOriginal = new BigDecimal(dados[2]);
            BigDecimal aumento = salarioOriginal.multiply(BigDecimal.valueOf(aumentoPercentual / 100));
            BigDecimal salarioEsperado = salarioOriginal.add(aumento);

            Funcionario funcionario = result.stream()
                .filter(f -> f.getNome().equals(dados[0]))
                .findFirst()
                .orElse(null);

            assertNotNull(funcionario);
            assertEquals(salarioEsperado.setScale(2, RoundingMode.HALF_EVEN), funcionario.getSalario().setScale(2, RoundingMode.HALF_EVEN));
        }
    }

    @Test
    public void deveAgruparOsFuncionariosPorCargoOuFuncao() {
        repositorio.addFuncionariosEmLote(new ArrayList<>());
        Map<String, List<Funcionario>> result = repositorio.groupByFuncao();
        
        for (String[] dados : repositorio.baseDeDados) {
            String funcao = dados[3];
            Funcionario funcionario = result.get(funcao).stream()
                .filter(f -> f.getNome().equals(dados[0]))
                .findFirst()
                .orElse(null);

            assertNotNull(funcionario);
            assertEquals(dados[0], funcionario.getNome());
        }
    }

}
