package com.attornatus.apirest.service;

import com.attornatus.apirest.entity.Endereco;
import com.attornatus.apirest.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listaEndereco(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id){
        return enderecoRepository.findById(id);
    }

    public void removerPorId(Long id){
        enderecoRepository.deleteById(id);
    }
}
