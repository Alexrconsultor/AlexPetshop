package br.com.tech4prova.petshop.service;

import java.util.List;

import br.com.tech4prova.petshop.model.Pet;

public interface PetService {
    Pet incluirPet(Pet pet);
    List<Pet> obterTodos();
    Pet obterPorId(String id);
    void removerPet(String id);
    Pet atualizarPet(String id, Pet pet);
}
