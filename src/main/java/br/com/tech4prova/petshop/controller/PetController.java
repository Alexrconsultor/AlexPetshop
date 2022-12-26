package br.com.tech4prova.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4prova.petshop.model.Pet;
import br.com.tech4prova.petshop.service.PetService;

@RestController
@RequestMapping("/api/petshop")
public class PetController {
    @Autowired
    private PetService servico;

    @GetMapping
    public ResponseEntity<List<Pet>> obterPet(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity <Pet> obterPorId(@PathVariable String id){
        return new ResponseEntity<>(servico.obterPorId(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Pet> incluirPet(@RequestBody Pet pet){
        return new ResponseEntity<>(servico.incluirPet(pet), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerPet(@PathVariable String id){
        servico.removerPet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="{id}")
    public Pet atualiPet(@PathVariable String id, @RequestBody Pet petnovo){
        return servico.atualizarPet(id, petnovo);
    }
}
