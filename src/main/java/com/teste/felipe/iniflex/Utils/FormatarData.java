package com.teste.felipe.iniflex.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    public LocalDate formatarDataStringParaLocalDate(String data) {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatarData);
    }

    public String formatarDataLocalDateParaString(LocalDate data){
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatada = data.format(formatarData);
        return dataNascimentoFormatada;
    }
    
}
