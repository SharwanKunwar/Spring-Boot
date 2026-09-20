package com.example.InterceptorFilter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy")
public class PolicyController
{
    @GetMapping("/info")
    public ResponseEntity<String> getPolicyInfo()
    {
        System.out.println("-------------------------------------- policy Info Returned ---");
        System.out.println("1. make one and two");
        System.out.println("2. can be use phones and laptops");
        return ResponseEntity.ok("getPolicyInfo() called.");
    }
}
