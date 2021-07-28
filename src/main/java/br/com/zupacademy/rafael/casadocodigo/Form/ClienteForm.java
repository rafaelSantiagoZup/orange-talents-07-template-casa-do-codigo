package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.CEP;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.CpfOuCnpj;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.Telefone;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;
import br.com.zupacademy.rafael.casadocodigo.models.Cliente;
import br.com.zupacademy.rafael.casadocodigo.models.Estado;
import br.com.zupacademy.rafael.casadocodigo.models.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {
    @NotNull @NotEmpty @Email
    @ValorUnico(classeDoDominio = Cliente.class,nomeDoCampo = "email",message = "O email deve ser único")
    private String email;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sobrenome;
    @NotNull @NotEmpty @CpfOuCnpj
    @ValorUnico(classeDoDominio = Cliente.class,nomeDoCampo = "documento",message = "O cpf ou o cnpj devem ser únicos")
    private String documento;
    @NotNull @NotEmpty
    private String endereco;
    @NotNull @NotEmpty
    private String complemento;
    @NotNull @NotEmpty
    private String cidade;
    @NotNull
    private Long paisId;
    @NotNull
    private Long estadoId;
    @NotNull @NotEmpty @Telefone
    private String telefone;
    @NotNull @NotEmpty @CEP
    private String cep;

    public ClienteForm() {
    }

    public Cliente toModel(EntityManager entityManager){
        Pais pais = entityManager.find(Pais.class,this.paisId);
        Estado estado = entityManager.find(Estado.class,this.estadoId);
        return new Cliente(this.email,this.nome,this.sobrenome,this.documento,this.endereco,this.complemento,this.cidade,pais,estado,this.telefone,this.cep);
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

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
