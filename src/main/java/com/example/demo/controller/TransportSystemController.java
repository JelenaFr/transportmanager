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


    @GetMapping("/stop/{areaInput}")
    @ResponseBody
    public ResponseEntity<List<String>> findAllStopsByArea(
            @PathVariable ("areaInput") String areaInput)
    {
        System.out.println(areaInput);
        System.out.println("Hello");
        System.out.println(transportSystemService.findallStopsThisArea(areaInput));
        return ResponseEntity.ok(transportSystemService.findallStopsThisArea(areaInput));
    }
    @GetMapping("/answer/{areaInput}/{stopInput}/{userLatitude}/{userLongitude}")
    @ResponseBody
    public ResponseEntity<List<String>>findAllNearestBusesByUserQuery(

            @PathVariable ("areaInput")String areaInput,
            @PathVariable ("stopInput")String stopInput,
            @PathVariable ("userLatitude")String userLatitude,
            @PathVariable ("userLongitude")String userLongitude)
    {

        System.out.println(transportSystemService.findAllBusesByUserQuery(stopInput));
        System.out.println(areaInput);
        System.out.println(stopInput);
        System.out.println(userLatitude);
        System.out.println(userLongitude);
        System.out.println("findAllNearestBusesByUserQuery");
        return ResponseEntity.ok(transportSystemService.findAllBusesByUserQuery(stopInput));

    }
}
