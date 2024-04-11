package com.example.proyectokafka_02.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProductorServicio {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviar(String topico, String mensaje) {
        kafkaTemplate.send(topico, mensaje);
    }

}
