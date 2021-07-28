package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;
import br.com.zupacademy.rafael.casadocodigo.models.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisForm {
    @NotNull @NotBlank
    @ValorUnico(nomeDoCampo = "nome",classeDoDominio = Pais.class,message = "O nome do país deve ser único")
    private String nome;

    public Pais toModel(){
        return new Pais(this.nome);
    }

    public PaisForm() {
    }

    public String getNome() {
        return nome;
    }
}
