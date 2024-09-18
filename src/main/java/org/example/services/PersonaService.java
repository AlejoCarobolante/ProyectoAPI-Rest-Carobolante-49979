package org.example.services;

import entities.Persona;
import jakarta.transaction.Transactional;
import repositories.PersonaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

    @Autowired
    private PersonaRepositoriy personaRepositoriy;

    public PersonaService( PersonaRepositoriy personaRepositoriy){
        this.personaRepositoriy = personaRepositoriy;
    }

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepositoriy.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepositoriy.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepositoriy.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
        Optional<Persona> entityOptional = personaRepositoriy.findById(id);
        Persona persona = entityOptional.get();
        persona = personaRepositoriy.save(persona);
        return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
        if (personaRepositoriy.existsById(id)){
            personaRepositoriy.deleteById(id);
            return true;
        }else {
            throw new Exception();
        }
        }catch (Exception e){
        throw new Exception(e.getMessage());
        }
    }
}
