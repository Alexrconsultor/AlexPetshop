package br.com.tech4prova.petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4prova.petshop.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String>{
    
}
