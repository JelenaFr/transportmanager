package com.example.demo.controller;

import com.example.demo.service.TransportSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TransportSystemController {
    @Autowired
    private TransportSystemService transportSystemService;

    @GetMapping("/area")
    public ResponseEntity<List<String>> findStopAreas() {
        return ResponseEntity.ok(transportSystemService.findUniqueStopAreas());
    }


//    @PostMapping("/res")
//    public String g(@RequestBody String s) {
//        System.out.println(s);
//        return s;
//    }


    @GetMapping("/stop")
    @ResponseBody
    public ResponseEntity<List<String>> findAllStopsByArea(@RequestParam(value = "", required = false) String areaInput) {

        System.out.println("Hello");
        System.out.println(transportSystemService.findallStopsThisArea(areaInput));

        return ResponseEntity.ok(transportSystemService.findallStopsThisArea(areaInput));


    }
}
