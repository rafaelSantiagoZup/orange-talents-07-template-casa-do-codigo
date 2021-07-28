package br.com.zupacademy.rafael.casadocodigo.repository;

import br.com.zupacademy.rafael.casadocodigo.models.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
