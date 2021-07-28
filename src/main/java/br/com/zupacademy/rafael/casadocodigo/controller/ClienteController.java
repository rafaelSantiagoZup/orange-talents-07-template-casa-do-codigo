package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.Form.ClienteForm;
import br.com.zupacademy.rafael.casadocodigo.models.Cliente;
import br.com.zupacademy.rafael.casadocodigo.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final EntityManager em;
    private final ClienteRepository clienteRepository;

    public ClienteController(EntityManager em, ClienteRepository clienteRepository) {
        this.em = em;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<String> addCliente(@RequestBody @Valid ClienteForm clienteForm){
        Cliente cliente = clienteForm.toModel(em);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente.toString());
    }
}
