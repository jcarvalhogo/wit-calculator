package br.com.jcarvalho.witlogger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValuesDTO {
    private BigDecimal n1;
    private BigDecimal n2;
    private BigDecimal result;
    private String operacao;
}
