package com.teste.felipe.iniflex.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {
        public LocalDate formatarDataLocalDate(String data) {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatarData);
    }

}
