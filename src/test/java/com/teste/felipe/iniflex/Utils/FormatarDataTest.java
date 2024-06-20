package com.teste.felipe.iniflex.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class FormatarDataTest {

    private final FormatarData formatarData = new FormatarData();
    
    @Test
    void deveFormatarUmaDataLocalDateNoPadraoDDMMAAAAEmString(){
        LocalDate dataCompleta = LocalDate.of(1986, 6, 23);
        var dataString = new String("23/06/1986");
        var dataLocalDate = formatarData.formatarDataLocalDateParaString(dataCompleta);
        assertEquals(dataLocalDate, dataString);
    }

    @Test
    void deveFormatarUmaStringDeDataEmDDMMAAParaLocalDate(){
        LocalDate dataCompleta = LocalDate.of(1986, 6, 23);
        var dataString = new String("23/06/1986");
        var formatada = formatarData.formatarDataStringParaLocalDate(dataString);
        assertEquals(formatada, dataCompleta);
    }

    @Test
    public void naoDeveFormatarDataStringParaLocalDateComFormatoInvalido() {
        String dataString = "1986/06/23";
        assertThrows(java.time.format.DateTimeParseException.class, () -> {
            formatarData.formatarDataStringParaLocalDate(dataString);
        }, "Era esperado lançar uma exceção para o formato de data inválido.");
    }

}