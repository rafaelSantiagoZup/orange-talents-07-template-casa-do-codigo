package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.IdUnico;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;
import br.com.zupacademy.rafael.casadocodigo.models.Estado;
import br.com.zupacademy.rafael.casadocodigo.models.Pais;
import br.com.zupacademy.rafael.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoForm {
    @NotNull @NotBlank
    @ValorUnico(nomeDoCampo = "nome",classeDoDominio = Estado.class,message = "O nome do Estado deve ser único")
    private String nome;
    @NotNull
    @IdUnico(classeDoDominio = Pais.class,nomeDoAtributo = "id")
    private Long paisId;

    public Estado toModel(PaisRepository paisRepository){
        Optional<Pais> pais = paisRepository.findById(paisId);
        return new Estado(this.nome,pais.get());
    }

    public EstadoForm() {
    }

    public EstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
