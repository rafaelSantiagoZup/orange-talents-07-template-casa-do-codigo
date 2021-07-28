package br.com.zupacademy.rafael.casadocodigo.controller;

import br.com.zupacademy.rafael.casadocodigo.DTO.LivroDetalhesDTO;
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
import java.util.Optional;

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
    public ResponseEntity<LivrosDTO> criaLivro(@RequestBody @Valid LivroForm livroForm){
        Livro livro = livroForm.toModel(categoriaRepository,autorRepository);
        livroRepository.save(livro);
        LivrosDTO livroDTO = new LivrosDTO(livro);
        return ResponseEntity.ok(livroDTO);
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
    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesDTO> detalhesLivro(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalhesDTO(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
