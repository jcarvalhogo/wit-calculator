package br.com.jcarvalho.witlogger.consumer;

import br.com.jcarvalho.witlogger.config.Config;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorLogger {

    @RabbitListener(queues = Config.QUEUE)
    public void consumeMessageFromQueue(Message message) {
        System.out.println("Messagem recebida: " + message.getBody());
    }
}
