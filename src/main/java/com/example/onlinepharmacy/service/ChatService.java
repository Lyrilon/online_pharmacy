package com.example.onlinepharmacy.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final Path docsPath = Path.of("src/main/resources/documents");
    private final List<String> history = new ArrayList<>();

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
            String answer = lines.stream()
                    .filter(l -> l.toLowerCase().contains(lower))
                    .findFirst()
                    .orElse("I'm sorry, I don't know the answer.");
            history.add("Q: " + question);
            history.add("A: " + answer);
            return answer;
        } catch (IOException e) {
            String error = "Error reading documents.";
            history.add("Q: " + question);
            history.add("A: " + error);
            return error;
        }
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
