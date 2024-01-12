package com.example.demo.service;

import com.example.demo.entity.Medic;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    @Autowired
    private MedicRepository medicRepository;

    public List<Medic> findAll() {
        return medicRepository.findAll();
    }

    public Medic findById(String id) {
        if (!medicRepository.existById(id)) {
            throw new NotFoundException("Not found Medic with ID: " + id);
        }

        return medicRepository.findById(id);
    }

    public void create(Medic medic) {
        if (medicRepository.existById(medic.getId())) {
            throw new AlreadyExistException("Already exist Medic with ID: " + medic.getId());
        }

        medicRepository.create(medic);
    }

    public void update(String id, Medic medic) {
        if (!medicRepository.existById(id)) {
            throw new NotFoundException("Not found Medic with ID: " + id);
        }

        medicRepository.update(id, medic);
    }

    public void delete(String id) {
        if (!medicRepository.existById(id)) {
            throw new NotFoundException("Not found Medic with ID: " + id);
        }

        medicRepository.delete(id);
    }
}
