package br.com.tech4prova.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4prova.petshop.model.Pet;
import br.com.tech4prova.petshop.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    private PetRepository repositorio;

    @Override
    public Pet incluirPet(Pet pet){
        return repositorio.save(pet);
    }

    @Override
    public List<Pet> obterTodos(){
        return repositorio.findAll();
    }

    @Override
    public Pet obterPorId(String id){
        return repositorio.findById(id).get();
    }

    @Override
    public void removerPet(String id){
        repositorio.deleteById(id);
    }

    @Override
    public Pet atualizarPet(String id, Pet pet){
        pet.setId(id);
        return repositorio.save(pet);
    }
}
