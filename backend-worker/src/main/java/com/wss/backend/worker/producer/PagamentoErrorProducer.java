package com.wss.backend.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErrorProducer {
    @Autowired private AmqpTemplate amqpTemplate;

    public void responseErrorMessage(String message) {
        amqpTemplate.convertAndSend(
                "pagamento-response-error-exchange",
                "pagamento-response-error-rout-key",
                message
        );
    }
}
