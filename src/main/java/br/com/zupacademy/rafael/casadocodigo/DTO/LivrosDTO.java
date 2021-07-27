package br.com.zupacademy.rafael.casadocodigo.DTO;

import br.com.zupacademy.rafael.casadocodigo.models.Livro;

public class LivrosDTO {
    private Long id;
    private String titulo;

    public LivrosDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
