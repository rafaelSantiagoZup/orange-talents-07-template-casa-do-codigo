package br.com.zupacademy.rafael.casadocodigo.DTO;

import br.com.zupacademy.rafael.casadocodigo.models.Pais;

public class PaisDTO {
    private Long id;
    private String nome;

    public PaisDTO(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
