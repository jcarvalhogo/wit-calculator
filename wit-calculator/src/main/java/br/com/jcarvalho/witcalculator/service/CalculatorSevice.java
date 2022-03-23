package br.com.jcarvalho.witcalculator.service;

import br.com.jcarvalho.witcalculator.dto.ValuesDTO;
import org.springframework.http.ResponseEntity;

public interface CalculatorSevice {
    ResponseEntity<ValuesDTO> soma(ValuesDTO values);

    ResponseEntity<ValuesDTO> subtracao(ValuesDTO values);

    ResponseEntity<ValuesDTO> divisao(ValuesDTO values);

    ResponseEntity<ValuesDTO> multiplicacao(ValuesDTO values);
}
