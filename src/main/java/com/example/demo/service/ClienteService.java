package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String kafkaTopic;

    // Mantén un registro del último timestamp consultado. Este valor debería ser persistente
    // en una ejecución real de la aplicación, por ejemplo, almacenándolo en una base de datos
    // o archivo de configuración.
    private LocalDateTime ultimoTimestamp = LocalDateTime.now().minusDays(1);

    @Scheduled(fixedRate = 60000) // Ajusta este valor según tus necesidades
    public void enviarClientesANuevoTopico() {
        // Usa el método personalizado del repositorio para obtener solo los clientes
        // añadidos después del último timestamp consultado.
        List<Cliente> nuevosClientes = clienteRepository.findAllWithFechaInsercionAfter(ultimoTimestamp);
        log.info("Empezamos de nuevo la nueva budsqueda...");
        log.info("Se encontraron {} nuevos registros para enviar a Kafka.", nuevosClientes.size());
        
        

        for (Cliente cliente : nuevosClientes) {
            log.info("Enviando cliente con ID: {} a Kafka.", cliente.getId());

            // Suponiendo que Cliente tiene un método toJson que convierte el objeto a un String JSON.
            // Si no es así, deberías implementar la serialización aquí.
            kafkaTemplate.send(kafkaTopic, cliente.toJson());
            
            // Actualiza el último timestamp consultado.
            // Esto asume que la lista está ordenada por fechaInsercion; de lo contrario,
            // necesitarás encontrar el registro más reciente de otra manera.
            if (cliente.getFechaInsercion().isAfter(ultimoTimestamp)) {
                ultimoTimestamp = cliente.getFechaInsercion();
            }
        }

    }
}
