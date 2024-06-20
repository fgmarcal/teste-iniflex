package com.teste.felipe.iniflex.Utils;

import java.math.BigDecimal;

/**
 * @implNote Classe singleton criada para guardar o valor do salário mínimo como uma constante
 */

public class SalarioMinimo {

    private static SalarioMinimo instance;
    private final BigDecimal valor;
    private final BigDecimal SALARIO_MINIMO = new BigDecimal(1212.00);

    private SalarioMinimo() {
        this.valor = SALARIO_MINIMO;
    }

    public static SalarioMinimo getInstance() {
        if (instance == null) {
            instance = new SalarioMinimo();
        }
        return instance;
    }

    public BigDecimal getValor() {
        return valor;
    }
}