package com.wss.backend.api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wss.backend.api.dto.PagamentoDTO;
import com.wss.backend.api.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {

    @Autowired private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar pagamento ..." + e.getMessage();
            //throw new RuntimeException(e);
        }
        return "Pagamento aguardando confirmacao....";
    }
}
