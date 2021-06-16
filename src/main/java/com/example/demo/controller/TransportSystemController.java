package com.example.demo.controller;

import com.example.demo.service.TransportSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
            @PathVariable("areaInput") String areaInput) {
        return ResponseEntity.ok(transportSystemService.findallStopsThisArea(areaInput));
    }

    @GetMapping("/answer/{areaInput}/{stopInput}/{userLatitude}/{userLongitude}")
    @ResponseBody
    public ResponseEntity<List<String>> findAllNearestBusesByUserQuery(

            @PathVariable("areaInput") String areaInput,
            @PathVariable("stopInput") String stopInput,
            @PathVariable("userLatitude") String userLatitude,
            @PathVariable("userLongitude") String userLongitude) {


        return ResponseEntity.ok(transportSystemService.findAllBusesByUserQuery(areaInput, stopInput));

    }


    @GetMapping("/location/{minLatitude}/{minLongitude}/{maxLatitude}/{maxLongitude}/{userLatitude}/{userLongitude}")
    @ResponseBody
    public ResponseEntity<String> findUserNearestUserStopsByLocationAutomatically(


            @PathVariable("minLatitude") Double minLatitude,
            @PathVariable("minLongitude") Double minLongitude,
            @PathVariable("maxLatitude") Double maxLatitude,
            @PathVariable("maxLongitude") Double maxLongitude,
            @PathVariable("userLatitude") Double userLatitude,
            @PathVariable("userLongitude") Double userLongitude
    ) {


        System.out.println(minLatitude);
        System.out.println(minLongitude);
        System.out.println(maxLatitude);
        System.out.println(maxLongitude);

        return ResponseEntity.ok(transportSystemService.findNearestStopsByLocation(minLatitude, minLongitude, maxLatitude, maxLongitude, userLatitude, userLongitude));

    }
}
