package com.example.onlinepharmacy.controller;

import com.example.onlinepharmacy.model.Drug;
import com.example.onlinepharmacy.service.DrugService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {

    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public List<Drug> all() {
        return drugService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> byId(@PathVariable Long id) {
        return drugService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Drug> search(@RequestParam String q) {
        return drugService.search(q);
    }
}
