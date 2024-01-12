package com.example.demo.service;

import com.example.demo.entity.Programare;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramareService {

    @Autowired
    private ProgramareRepository programareRepository;

    public List<Programare> findAll() {
        return programareRepository.findAll();
    }

    public Programare findById(int id) {
        if (!programareRepository.existById(id)) {
            throw new NotFoundException("Not found Programare with ID: " + id);
        }

        return programareRepository.findById(id);
    }

    public void create(Programare programare) {
        programareRepository.create(programare);
    }

    public void update(int id, Programare programare) {
        if (!programareRepository.existById(id)) {
            throw new NotFoundException("Not found Programare with ID: " + id);
        }

        programareRepository.update(id, programare);
    }

    public void delete(int id) {
        if (!programareRepository.existById(id)) {
            throw new NotFoundException("Not found Programare with ID: " + id);
        }

        programareRepository.delete(id);
    }
}
