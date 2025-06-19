package com.example.onlinepharmacy.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final Path docsPath = Path.of("src/main/resources/documents");

    public String ask(String question) {
        try {
            List<String> lines = Files.walk(docsPath)
                    .filter(p -> p.toString().endsWith(".txt"))
                    .flatMap(p -> {
                        try {
                            return Files.lines(p);
                        } catch (IOException e) {
                            return List.<String>of().stream();
                        }
                    })
                    .collect(Collectors.toList());
            String lower = question.toLowerCase();
            return lines.stream()
                    .filter(l -> l.toLowerCase().contains(lower))
                    .findFirst()
                    .orElse("I'm sorry, I don't know the answer.");
        } catch (IOException e) {
            return "Error reading documents.";
        }
    }
}
