package com.example.demo.controller;

import com.example.demo.entity.Spital;
import com.example.demo.service.SpitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spitale")
public class SpitalController {

    @Autowired
    private SpitalService spitalService;

    @GetMapping
    public List<Spital> getAllSpitale() {
        return spitalService.findAll();
    }

    @GetMapping("/{id}")
    public Spital getSpitalById(@PathVariable int id) {
        return spitalService.findById(id);
    }

    @PostMapping
    public void createSpital(@RequestBody Spital spital) {
        spitalService.create(spital);
    }

    @PutMapping("/{id}")
    public void updateSpital(@PathVariable int id, @RequestBody Spital spital) {
        spitalService.update(id, spital);
    }

    @DeleteMapping("/{id}")
    public void deleteSpital(@PathVariable int id) {
        spitalService.delete(id);
    }
}
