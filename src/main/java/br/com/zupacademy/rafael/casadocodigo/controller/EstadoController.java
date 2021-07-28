package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.DTO.EstadoDTO;
import br.com.zupacademy.rafael.casadocodigo.Form.EstadoForm;
import br.com.zupacademy.rafael.casadocodigo.models.Estado;
import br.com.zupacademy.rafael.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.rafael.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public EstadoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDTO> addEstado(@RequestBody @Valid EstadoForm estadoForm){
        Estado estado = estadoForm.toModel(paisRepository);
        estadoRepository.save(estado);
        EstadoDTO estadoDTO = new EstadoDTO(estado);
        return ResponseEntity.ok(estadoDTO);
    }
}
