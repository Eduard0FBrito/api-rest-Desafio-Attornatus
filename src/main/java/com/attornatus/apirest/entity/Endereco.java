package com.attornatus.apirest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "principal", nullable = false)
    private Boolean principal;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pessoa pessoa;
}
