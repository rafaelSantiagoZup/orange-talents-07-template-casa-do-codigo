package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.DTO.LivrosDTO;
import br.com.zupacademy.rafael.casadocodigo.Form.LivroForm;
import br.com.zupacademy.rafael.casadocodigo.models.Livro;
import br.com.zupacademy.rafael.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.rafael.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.rafael.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<Livro> criaLivro(@RequestBody @Valid LivroForm livroForm){
        Livro livro = livroForm.toModel(categoriaRepository,autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<LivrosDTO> listarLivros(){
        List<LivrosDTO> retorno = new ArrayList<LivrosDTO>();
        List<Livro> livrosSalvos = livroRepository.findAll();
        livrosSalvos.forEach(livro->{
            retorno.add(new LivrosDTO(livro));
        });
        return retorno;
    }
}
