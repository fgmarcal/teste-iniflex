package com.teste.felipe.iniflex.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class FormatarValorTest {

    @Test
    void deveAlterarUmValorFormatadoComDuasCasasDepoisDaVirgula(){
        BigDecimal valor = new BigDecimal(3000);
        BigDecimal valor2 = new BigDecimal("3000");

        String valorTestado = "3.000,00";

        var resultado = new FormatarValor().formatar(valor);
        var resultado2 = new FormatarValor().formatar(valor2);

        assertEquals(resultado, valorTestado);
        assertEquals(resultado2, valorTestado);
    }

    @Test
    void deveFalharQuandoOValorInseridoNaoSejaValido(){
        try {
            new FormatarValor().formatar(new BigDecimal("3000,00"));
            fail();
        } catch (Exception e) {
            assertEquals(e, e);
        }
        
    }
    
}
