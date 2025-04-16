package br.com;

import br.com.configuration.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderMessage(String message) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.ROUTING_KEY,
                message
        );
        System.out.println("Mensagem enviada: " + message);
    }
}
