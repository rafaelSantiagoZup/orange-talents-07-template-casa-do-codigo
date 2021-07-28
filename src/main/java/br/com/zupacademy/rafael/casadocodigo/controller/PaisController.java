package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.DTO.PaisDTO;
import br.com.zupacademy.rafael.casadocodigo.Form.PaisForm;
import br.com.zupacademy.rafael.casadocodigo.models.Pais;
import br.com.zupacademy.rafael.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/pais")
public class PaisController {
    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDTO> addPais(@RequestBody @Valid PaisForm paisForm){
        Pais pais = paisForm.toModel();
        paisRepository.save(pais);
        PaisDTO paisDTO = new PaisDTO(pais);

        return ResponseEntity.ok(paisDTO);
    }
}
