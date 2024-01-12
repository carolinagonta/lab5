package com.example.demo.controller;

import com.example.demo.entity.Medic;
import com.example.demo.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medici")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping
    public List<Medic> getAllMedici() {
        return medicService.findAll();
    }

    @GetMapping("/{id}")
    public Medic getMedicById(@PathVariable String id) {
        return medicService.findById(id);
    }

    @PostMapping
    public void createMedic(@RequestBody Medic medic) {
        medicService.create(medic);
    }

    @PutMapping("/{id}")
    public void updateMedic(@PathVariable String id, @RequestBody Medic medic) {
        medicService.update(id, medic);
    }

    @DeleteMapping("/{id}")
    public void deleteMedic(@PathVariable String id) {
        medicService.delete(id);
    }
}
