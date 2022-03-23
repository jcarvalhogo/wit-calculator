package br.com.jcarvalho.witlogger.consumer;

import br.com.jcarvalho.witlogger.config.Config;
import br.com.jcarvalho.witlogger.dto.ValuesDTO;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class CalculatorLogger {

    protected final Gson gson;
    public static final Logger LOGGER = Logger.getLogger(CalculatorLogger.class.getName());

    public CalculatorLogger() {
        this.gson = new Gson();
    }

    @RabbitListener(queues = Config.QUEUE)
    public void consumeMessageFromQueue(String message) {
        if (message != null && !message.isEmpty()) {
            ValuesDTO values = gson.fromJson(message, ValuesDTO.class);
            StringBuilder saida = new StringBuilder();
            saida.append("Resutado da Operação " + values.getOperacao() + " | ");
            saida.append("Valor de entrada: N1: " + values.getN1() + " | ");
            saida.append("Valor de entrada: N2: " + values.getN2() + " | ");
            saida.append("Resultado da operação: " + values.getResult());

            LOGGER.info(saida.toString());
        }
    }
}
