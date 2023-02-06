package com.attornatus.apirest.entity;

import com.attornatus.apirest.entity.Endereco;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "dataNascimento", nullable = false)
    private String dataNascimento;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}

