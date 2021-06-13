package com.example.demo.controller;

import com.example.demo.entity.Stop;
import com.example.demo.service.TransportSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TransportSystemController {
    @Autowired
    private TransportSystemService transportSystemService;

    @GetMapping("/area")
    public ResponseEntity<List<String>> findStopAreas() {
        transportSystemService.findUniqueStopAreas().forEach(System.out::println);
        return ResponseEntity.ok(transportSystemService.findUniqueStopAreas());
    }




}
