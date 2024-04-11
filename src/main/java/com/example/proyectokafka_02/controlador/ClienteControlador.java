package com.example.proyectokafka_02.controlador;

import com.example.proyectokafka_02.modelo.Cliente;
import com.example.proyectokafka_02.repositorio.ClienteRepository;
import com.example.proyectokafka_02.servicio.KafkaProductorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClienteControlador {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private KafkaProductorServicio kafkaProductorServicio;

    @Value("${kafka.topic.nombre}")
    private String nombreTopico;

    @GetMapping("/enviar")
    public String enviarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente ->
                kafkaProductorServicio.enviar(nombreTopico, cliente.toJson())); // Envía como JSON
        return "Clientes enviados";
    }
}
