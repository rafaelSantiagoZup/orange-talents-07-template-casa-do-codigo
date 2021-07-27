package br.com.zupacademy.rafael.casadocodigo.Form;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.MustBeFuture;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;
import br.com.zupacademy.rafael.casadocodigo.models.Livro;
import br.com.zupacademy.rafael.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.rafael.casadocodigo.repository.CategoriaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LivroForm {
    @NotNull
    @NotEmpty
    @ValorUnico(message = "O título deve ser único",
            classeDoDominio = Livro.class,
            nomeDoCampo = "titulo")
    private String titulo;
    @NotNull @NotEmpty @Length(max =500)
    private String resumo;
    @NotNull @DecimalMin("20.00")
    private Float preco;
    @NotNull @Min(100)
    private Integer paginas;
    @NotNull @NotEmpty
    private String isbn;
    @MustBeFuture
    private String dataLancamento;
    @NotNull
    private Long categoria;
    @NotNull
    private Long autor;

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        BigDecimal preco = new BigDecimal(this.preco);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate local = LocalDate.parse(this.dataLancamento, formatter);
        return new Livro(this.titulo,this.resumo,preco,this.paginas,this.isbn,local,categoriaRepository.findById(this.categoria).get(),autorRepository.findById(this.autor).get());
    }

    public LivroForm(String titulo, String resumo, Float preco, Integer paginas, String isbn, String dataLancamento, Long categoria, Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public LivroForm() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public Float getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }
}
