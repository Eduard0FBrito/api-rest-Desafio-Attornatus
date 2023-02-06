package com.attornatus.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attornatus.apirest.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
