package com.teste.felipe.iniflex.Servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.teste.felipe.iniflex.Entidades.Funcionario.Funcionario;
import com.teste.felipe.iniflex.Repositorio.Repositorio;
import com.teste.felipe.iniflex.Utils.FormatarValor;
import com.teste.felipe.iniflex.Utils.SalarioMinimo;

public class ServicoDeImpressaoTest {

    private Repositorio repositorio;

    private ServicoDeImpressao servicoDeImpressao;

    @BeforeEach
    public void setUp() {
        List<Funcionario> funcionarios = new ArrayList<>();
        repositorio = new Repositorio(funcionarios);
        repositorio.addFuncionariosEmLote(funcionarios);
        servicoDeImpressao = new ServicoDeImpressao(repositorio);
    }

    @Test
    void deveImprimirUmaListaSeparadaPorFuncao(){
        Funcionario funcionario = repositorio.getFuncionarios().get(0);
        String funcao = funcionario.getFuncao();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirPorFuncao();

        String output = outContent.toString();
        assertTrue(output.contains("Função: " + funcao));
    }

    @Test
    void deveImprimirAniversariantesDeUmMesEspecifico() {
        Funcionario funcionario = repositorio.getFuncionarios().get(0);
        int mesNascimento = funcionario.getDataNascimento().getMonthValue();


        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirAniversariantesMes(mesNascimento);

        String output = outContent.toString();
        assertTrue(output.contains(funcionario.getNome()));
    }

    @Test
    void deveImprimirFuncionarioMaisVelho() {
        Funcionario buscaMaisVelho = repositorio.getFuncionarios().get(0);

        for (Funcionario funcionario : repositorio.getFuncionarios()) {
            if (funcionario.getDataNascimento().isBefore(buscaMaisVelho.getDataNascimento())) {
                buscaMaisVelho = funcionario;
            }
        }

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirFuncionarioMaisVelho();

        String output = outContent.toString();
        assertTrue(output.contains(buscaMaisVelho.getNome()));
    }

    @Test
    void deveImprimirFuncionariosPorOrdemAlfabetica() {
        List<String> listFuncionarios = new ArrayList<>();
        for (Funcionario funcionario : repositorio.getFuncionarios()) {
            listFuncionarios.add(funcionario.getNome());
        }
        List<String> listFuncionariosOrdenada = new ArrayList<>(listFuncionarios);
        Collections.sort(listFuncionariosOrdenada);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirFuncionariosPorOrdemAlfabetica();

        String output = outContent.toString();
        String[] outputLines = output.split("\n");
        List<String> outputNames = new ArrayList<>();
        for (String line : outputLines) {
            if (line.contains("Nome:")) {
                outputNames.add(line.split(",")[0].split(":")[1].trim());
            }
        }

        assertEquals(listFuncionariosOrdenada, outputNames);
    }

    @Test
    void deveImprimirTotalSalariosSomados() {

        BigDecimal sumSalario = BigDecimal.ZERO;
        for (Funcionario funcionario : repositorio.getFuncionarios()) {
            sumSalario = sumSalario.add(funcionario.getSalario());
        }
        String formattedSumSalario = new FormatarValor().formatar(sumSalario);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirTotalSalarios();

        String output = outContent.toString();
        assertTrue(output.contains(formattedSumSalario));
    }

    @Test
    void deveImprimirQuantosSalariosMinimosFuncionarios() {
        BigDecimal salarioMinimo = SalarioMinimo.getInstance().getValor();
        Funcionario primeiroFuncionario = repositorio.getFuncionarios().get(0);
        BigDecimal quantidadeSalariosMinimos = primeiroFuncionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_EVEN);
        String resultadoEsperado = primeiroFuncionario.getNome() + ": " + new FormatarValor().formatar(quantidadeSalariosMinimos) + " salários mínimos";

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        servicoDeImpressao.imprimirSalariosMinimos();

        String output = outContent.toString();
        assertTrue(output.contains(resultadoEsperado));
    }
}
