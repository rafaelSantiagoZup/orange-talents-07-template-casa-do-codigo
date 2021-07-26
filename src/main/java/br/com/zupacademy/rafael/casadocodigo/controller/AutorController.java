package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.Form.AutorForm;
import br.com.zupacademy.rafael.casadocodigo.models.Autor;
import br.com.zupacademy.rafael.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<Autor> criaAutor(@RequestBody @Valid AutorForm autorForm){
        autorRepository.save(autorForm.converteAutorFormParaAutor());
        return ResponseEntity.ok().build();
    }

}
