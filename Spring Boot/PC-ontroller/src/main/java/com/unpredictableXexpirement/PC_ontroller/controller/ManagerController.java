package com.unpredictableXexpirement.PC_ontroller.controller;

import com.unpredictableXexpirement.PC_ontroller.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/open-chrome")
    public ResponseEntity<String> openChrome() {

        String response = managerService.openChrome();

        return ResponseEntity.ok(response);
    }
}