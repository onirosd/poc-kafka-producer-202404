package com.example.proyectokafka_02.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.time.ZoneId;
import java.time.LocalDateTime;
import com.example.proyectokafka_02.repositorio.ClienteRepository;

import java.text.SimpleDateFormat;
import java.util.List;
import com.example.proyectokafka_02.modelo.Cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ClientePollingService {

    private static final Logger logger = LoggerFactory.getLogger(ClientePollingService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private KafkaProductorServicio kafkaProductorServicio;

    @Value("${kafka.topic.nombre}")
    private String nombreTopico;
    
    // Almacenar el timestamp del último registro procesado
    private Date ultimoTimestamp = Date.from(LocalDateTime.now()
                                                .atZone(ZoneId.of("America/Lima"))
                                                .toInstant());
    // logger.info("Ejecutando polling de nuevos clientes. Último timestamp: {}", dateFormat.format(ultimoTimestamp));

    @Scheduled(fixedRate = 5000) // Ajusta este valor según tus necesidades
    public void buscarYEnviarNuevosClientes() {
        logger.info("Ejecutando polling de nuevos clientes. Último timestamp: {}", dateFormat.format(ultimoTimestamp));
        
        List<Cliente> nuevosClientes = clienteRepository.findAllWithFechaInsercionAfter(ultimoTimestamp);
        logger.info("Número de nuevos clientes encontrados: {}", nuevosClientes.size());
        
        nuevosClientes.forEach(cliente -> {
            logger.info("Enviando cliente al tópico {}: {}", nombreTopico, cliente.toJson());
           
            kafkaProductorServicio.enviar(nombreTopico, cliente.toJson()); // Asegúrate de implementar toJson() adecuadamente en Cliente
            ultimoTimestamp = cliente.getFechaInsercion(); // Actualizar ultimoTimestamp al del último cliente procesado
        });

        if (!nuevosClientes.isEmpty()) {
            logger.info("Actualizando último timestamp a: {}", dateFormat.format(ultimoTimestamp));
        }
    }
}