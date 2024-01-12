package com.example.demo.service;

import com.example.demo.entity.Spital;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SpitalRepository;

import java.util.List;

@Service
public class SpitalService {

    @Autowired
    private SpitalRepository spitalRepository;

    public List<Spital> findAll() {
        return spitalRepository.findAll();
    }

    public Spital findById(int id) {
        if (!spitalRepository.existById(id)) {
            throw new NotFoundException("Not found Spital with ID: " + id);
        }

        return spitalRepository.findById(id);
    }

    public void create(Spital spital) {
        if (spitalRepository.existByDenumire(spital.getDenumire())) {
            throw new AlreadyExistException(
                    "Already exist Spital with Denumire: " + spital.getDenumire());
        }

        spitalRepository.create(spital);
    }


    public void update(int id, Spital spital) {
        spitalRepository.update(id, spital);
    }

    public void delete(int id) {
        spitalRepository.delete(id);
    }
}
