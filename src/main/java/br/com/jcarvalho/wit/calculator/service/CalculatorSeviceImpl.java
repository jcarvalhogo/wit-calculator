package br.com.jcarvalho.wit.calculator.service;

import br.com.jcarvalho.wit.calculator.dto.ValuesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorSeviceImpl implements CalculatorSevice {

    @Override
    public ResponseEntity<ValuesDTO> soma(ValuesDTO values) {
        values.setResult(values.getN1().add(values.getN2()));
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> subtracao(ValuesDTO values) {
        values.setResult(values.getN1().subtract(values.getN2()));
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> divisao(ValuesDTO values) {
        values.setN2(new BigDecimal(values.getN2().toBigInteger()));
        values.setResult(values.getN1().divide(values.getN2()));
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> multiplicacao(ValuesDTO values) {
        values.setResult(values.getN1().multiply(values.getN2()));
        return ResponseEntity.ok().body(values);
    }
}
