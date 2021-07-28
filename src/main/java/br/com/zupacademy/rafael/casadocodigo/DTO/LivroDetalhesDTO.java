package br.com.zupacademy.rafael.casadocodigo.DTO;

import br.com.zupacademy.rafael.casadocodigo.models.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhesDTO {
    private String titulo;
    private String resumo;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private LocalDate dataLancamento;
    private String categoria;
    private String autor;

    public LivroDetalhesDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getNome();
    }

    public LivroDetalhesDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }
}
