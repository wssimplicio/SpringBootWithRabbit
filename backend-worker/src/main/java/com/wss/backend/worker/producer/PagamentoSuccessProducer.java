package com.wss.backend.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSuccessProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void responseSuccessMessage(String message) {
        amqpTemplate.convertAndSend(
                "pagamento-response-success-exchange",
                "pagamento-response-success-rout-key",
                message
        );
    }
}
