package br.com.zupacademy.rafael.casadocodigo.models;


import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo nome é obrigatório!")
    @NotEmpty
    @Column(nullable = false)
    private String nome;
    @NotNull(message = "O campo email é obrigatório!")
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Column(length = 400,nullable = false)
    private String descricao;
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
