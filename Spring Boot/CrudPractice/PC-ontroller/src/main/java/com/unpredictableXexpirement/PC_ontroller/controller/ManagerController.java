package com.unpredictableXexpirement.PC_ontroller.controller;

import com.unpredictableXexpirement.PC_ontroller.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@CrossOrigin(origins = "http://localhost:5173")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    // =========================
    // CHROME
    // =========================

    @PostMapping("/open-chrome")
    public ResponseEntity<String> openChrome() {

        return ResponseEntity.ok(
                managerService.openChrome()
        );
    }


    // =========================
    // TERMINAL
    // =========================

    @PostMapping("/open-terminal")
    public ResponseEntity<String> openTerminal() {

        return ResponseEntity.ok(
                managerService.openTerminal()
        );
    }


    // =========================
    // FILE MANAGER
    // =========================

    @PostMapping("/open-files")
    public ResponseEntity<String> openFiles() {

        return ResponseEntity.ok(
                managerService.openFiles()
        );
    }


    // =========================
    // TEXT EDITOR
    // =========================

    @PostMapping("/open-editor")
    public ResponseEntity<String> openEditor() {

        return ResponseEntity.ok(
                managerService.openEditor()
        );
    }
}