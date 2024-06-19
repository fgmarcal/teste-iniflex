package com.teste.felipe.iniflex.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatarValor extends DecimalFormat {
    
    public String formatar(BigDecimal valor){
        DecimalFormat formatador = new DecimalFormat("#,###.00");
        var resultado = formatador.format(valor);
        return resultado;
    }
}
