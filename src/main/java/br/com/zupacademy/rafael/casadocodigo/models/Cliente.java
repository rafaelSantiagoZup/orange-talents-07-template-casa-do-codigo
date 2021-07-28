package br.com.zupacademy.rafael.casadocodigo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false,unique = true)
    private String documento;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(@NotNull @NotEmpty @Email String email,@NotNull @NotEmpty String nome, @NotNull @NotEmpty String sobrenome,@NotNull @NotEmpty String documento,@NotNull @NotEmpty String endereco,@NotNull @NotEmpty String complemento,@NotNull @NotEmpty String cidade,@NotNull Pais pais,Estado estado,@NotNull @NotEmpty String telefone,@NotNull @NotEmpty String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "{"+"\""+"id"+"\""+":"+
                id +
                '}';
    }
}
