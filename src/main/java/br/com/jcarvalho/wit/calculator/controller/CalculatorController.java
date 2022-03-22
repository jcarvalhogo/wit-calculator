package br.com.jcarvalho.wit.calculator.controller;

import br.com.jcarvalho.wit.calculator.dto.ValuesDTO;
import br.com.jcarvalho.wit.calculator.service.CalculatorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorSevice service;

    @PostMapping("/soma")
    public ResponseEntity somar(@RequestBody ValuesDTO value) {
        return service.soma(value);
    }

    @PostMapping("/subtracao")
    public ResponseEntity subtracao(@RequestBody ValuesDTO value) {
        return service.subtracao(value);
    }

    @PostMapping("/divisao")
    public ResponseEntity divisao(@RequestBody ValuesDTO value) {
        return service.divisao(value);
    }

    @PostMapping("/multiplicacao")
    public ResponseEntity multiplicacao(@RequestBody ValuesDTO value) {
        return service.multiplicacao(value);
    }

}
