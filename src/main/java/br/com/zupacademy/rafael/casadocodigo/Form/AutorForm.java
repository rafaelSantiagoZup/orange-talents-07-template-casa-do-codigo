package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.models.Autor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorForm {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @Email
    private String email;
    @NotNull @NotEmpty
    @Length(max = 400)
    private String descricao;

    public Autor converteAutorFormParaAutor(){
        return new Autor(this.nome,this.email,this.descricao);
    }

}
