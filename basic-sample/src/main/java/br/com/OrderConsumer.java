package br.com;

import br.com.configuration.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}