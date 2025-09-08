package com.wss.backend.worker.consumer;

import com.wss.backend.worker.producer.PagamentoErrorProducer;
import com.wss.backend.worker.producer.PagamentoSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumer {

    @Autowired private PagamentoErrorProducer pagamentoErrorProducer;
    @Autowired private PagamentoSuccessProducer pagamentoSuccessProducer;

    @RabbitListener( queues = {"pagamento-request-queue"})
    public void receberMensagem(@Payload Message message) {
        System.out.println(message);

        if (new Random().nextBoolean()) {
            pagamentoSuccessProducer.responseSuccessMessage("Pagamento realizado com sucesso !" + message);
        } else {
            pagamentoErrorProducer.responseErrorMessage("Erro ao processar pagamento!" + message);
        }
    }
}
