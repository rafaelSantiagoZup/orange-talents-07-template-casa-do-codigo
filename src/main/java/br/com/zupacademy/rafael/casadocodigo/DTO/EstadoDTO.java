package br.com.zupacademy.rafael.casadocodigo.DTO;

import br.com.zupacademy.rafael.casadocodigo.models.Estado;

public class EstadoDTO {
    private Long id;
    private String nome;
    private String pais;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}
