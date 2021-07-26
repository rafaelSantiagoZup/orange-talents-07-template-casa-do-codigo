package br.com.zupacademy.rafael.casadocodigo.repository;

import br.com.zupacademy.rafael.casadocodigo.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
