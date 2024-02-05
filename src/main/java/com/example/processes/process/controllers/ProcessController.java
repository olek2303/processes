package com.example.processes.process.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProcessController {
//    @Autowired
//    private ProcessRepository processRepo;
    @GetMapping("/processes")
    public String getProcesses(ModelMap model) {
        List<String> processes = getProcessesList();
        // Wypisz wynik w konsoli
        for (String process : processes) {
            System.out.println(process);
        }
        // Zamiast zwracać widok, możesz zwrócić pusty widok lub przekierowanie
        return "redirect:/";
    }

    private List<String> getProcessesList() {
        List<String> uniqueProcesses = new ArrayList<>();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                // Dla każdego wiersza, pobierz nazwę procesu (pierwsze słowo w wierszu)
                String[] tokens = line.split("\\s+");
                if (tokens.length > 0) {
                    String processName = tokens[0];
                    // Dodaj unikalną nazwę procesu do listy
                    if (!uniqueProcesses.contains(processName)) {
                        uniqueProcesses.add(processName);
                    }
                }
            }
            process.waitFor(); // Poczekaj na zakończenie procesu
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return uniqueProcesses;
    }
    
//    @PostMapping("/save-selected")
    
}
