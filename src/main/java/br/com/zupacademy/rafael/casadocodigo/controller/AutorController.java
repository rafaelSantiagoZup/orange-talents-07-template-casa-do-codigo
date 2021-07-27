package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.Form.AutorForm;
import br.com.zupacademy.rafael.casadocodigo.models.Autor;
import br.com.zupacademy.rafael.casadocodigo.repository.AutorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Autor> criaAutor(@RequestBody @Valid AutorForm autorForm) throws DataIntegrityViolationException {
        Autor autor = autorForm.converteAutorFormParaAutor();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }

}
