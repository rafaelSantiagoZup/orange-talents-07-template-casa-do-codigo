package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.NomeUnico;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;
import br.com.zupacademy.rafael.casadocodigo.models.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaForm {
    @ValorUnico(nomeDoCampo = "nome",classeDoDominio = Categoria.class,message = "O campo nome deve ser único!")
    @NotNull
    @NotEmpty
    private String nome;

    public CategoriaForm() {
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
