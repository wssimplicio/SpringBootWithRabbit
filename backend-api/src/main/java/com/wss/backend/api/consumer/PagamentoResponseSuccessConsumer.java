package com.wss.backend.api.consumer;

import com.wss.backend.api.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PagamentoResponseSuccessConsumer {

    @Autowired private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"pagamento-response-success-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.successPagamento(payload);
    }
}
