package com.example.demo.controller;

import com.example.demo.entity.Programare;
import com.example.demo.service.ProgramareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programari")
public class ProgramareController {

    @Autowired
    private ProgramareService programareService;

    @GetMapping
    public List<Programare> getAllProgramari() {
        return programareService.findAll();
    }

    @GetMapping("/{id}")
    public Programare getProgramareById(@PathVariable int id) {
        return programareService.findById(id);
    }

    @PostMapping
    public void createProgramare(@RequestBody Programare programare) {
        programareService.create(programare);
    }

    @PutMapping("/{id}")
    public void updateProgramare(@PathVariable int id, @RequestBody Programare programare) {
        programareService.update(id, programare);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramare(@PathVariable int id) {
        programareService.delete(id);
    }
}
