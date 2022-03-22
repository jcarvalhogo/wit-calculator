package br.com.jcarvalho.wit.calculator.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ValuesDTO {
    private BigDecimal n1;
    private BigDecimal n2;
    private BigDecimal result;

    public BigDecimal getN1() {
        return n1;
    }

    public void setN1(BigDecimal n1) {
        this.n1 = n1;
    }

    public BigDecimal getN2() {
        return n2;
    }

    public void setN2(BigDecimal n2) {
        this.n2 = n2;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValuesDTO valuesDTO = (ValuesDTO) o;
        return Objects.equals(n1, valuesDTO.n1) && Objects.equals(n2, valuesDTO.n2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2);
    }
}
