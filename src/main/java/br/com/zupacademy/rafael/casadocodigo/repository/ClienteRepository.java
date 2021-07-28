package br.com.zupacademy.rafael.casadocodigo.repository;

import br.com.zupacademy.rafael.casadocodigo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
