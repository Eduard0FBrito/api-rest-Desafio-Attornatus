package com.attornatus.apirest.http.controller;

import com.attornatus.apirest.entity.Endereco;
import com.attornatus.apirest.service.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco Endereco){
        return enderecoService.salvar(Endereco);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listaEnderecos(){
        return enderecoService.listaEndereco();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco buscarEnderecoPorId(@PathVariable("id") Long id){
        return enderecoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Endereco não encontrada"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable("id") Long id){
        enderecoService.buscarPorId(id)
                .map(Endereco -> {
                    enderecoService.removerPorId(Endereco.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Endereco não encontrada"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEndereco(@PathVariable("id") Long id, @RequestBody Endereco Endereco){
        enderecoService.buscarPorId(id)
                .map(EnderecoBase -> {
                    modelMapper.map(Endereco, EnderecoBase);
                    enderecoService.salvar(EnderecoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrada"));
    }
}
