package com.example.onlinepharmacy.service;

import com.example.onlinepharmacy.model.Drug;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrugService {
    private final List<Drug> drugs = new ArrayList<>();

    @PostConstruct
    public void init() {
        drugs.add(new Drug(1L, "Aspirin", "Pain reliever", 5.0));
        drugs.add(new Drug(2L, "Ibuprofen", "Anti-inflammatory", 8.0));
        drugs.add(new Drug(3L, "Amoxicillin", "Antibiotic", 12.0));
    }

    public List<Drug> findAll() {
        return drugs;
    }

    public Optional<Drug> findById(Long id) {
        return drugs.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public List<Drug> search(String query) {
        return drugs.stream()
                .filter(d -> d.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
