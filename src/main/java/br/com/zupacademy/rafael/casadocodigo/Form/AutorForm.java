package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.models.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AutorForm {
    @NotEmpty
    @NotNull
    private String nome;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @NotNull
    @Length(max = 400)
    private String descricao;

    public AutorForm() {
    }

    public Autor converteAutorFormParaAutor(){

        return new Autor(this.nome,this.email,this.descricao);
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
}
