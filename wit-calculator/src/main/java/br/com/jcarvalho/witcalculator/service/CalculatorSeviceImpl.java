package br.com.jcarvalho.witcalculator.service;

import br.com.jcarvalho.witcalculator.config.Config;
import br.com.jcarvalho.witcalculator.dto.ValuesDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorSeviceImpl implements CalculatorSevice {

    @Autowired
    private Environment env;

    @Autowired
    private RabbitTemplate template;

    @Override
    public ResponseEntity<ValuesDTO> soma(ValuesDTO values) {
        values.setResult(values.getN1().add(values.getN2()));
        queueCreate(values);
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> subtracao(ValuesDTO values) {
        values.setResult(values.getN1().subtract(values.getN2()));
        queueCreate(values);
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> divisao(ValuesDTO values) {
        values.setN2(new BigDecimal(values.getN2().toBigInteger()));
        values.setResult(values.getN1().divide(values.getN2()));
        queueCreate(values);
        return ResponseEntity.ok().body(values);
    }

    @Override
    public ResponseEntity<ValuesDTO> multiplicacao(ValuesDTO values) {
        values.setResult(values.getN1().multiply(values.getN2()));
        queueCreate(values);
        return ResponseEntity.ok().body(values);
    }

    private void queueCreate(ValuesDTO values) {
        template.convertAndSend(env.getProperty("rabbit.wit.change"), env.getProperty("rabbit.wit.routing.key"), values);
    }
}
