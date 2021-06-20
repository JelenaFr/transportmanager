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


    @GetMapping("/stop/{area}")
    @ResponseBody
    public ResponseEntity<List<String>> findAllStopsByArea(
            @PathVariable("area") String area) {
        return ResponseEntity.ok(transportSystemService.findallStopsThisArea(area));
    }

    @GetMapping("/buses/{area}/{stop}")
    @ResponseBody
    public ResponseEntity<List<String>> findAllNearestBusesByUserQuery(@PathVariable("area") String area,
                                                                       @PathVariable("stop") String stop) {
        return ResponseEntity.ok(transportSystemService.findAllBusesByUserQuery(area, stop));
    }


    @GetMapping("/location/{userLatitude}/{userLongitude}")
    @ResponseBody
    public ResponseEntity<String> findUserNearestUserStopsByLocationAutomatically(@PathVariable("userLatitude") Double userLatitude,
                                                                                  @PathVariable("userLongitude") Double userLongitude) {
        return ResponseEntity.ok(transportSystemService.findNearestStopsByLocation(userLatitude, userLongitude));
    }


    @GetMapping("/timetable/{area}/{stop}/{bus}")
    @ResponseBody
    public ResponseEntity<List<String>> findCurrentStopTimetable(@PathVariable("area") String area,
                                                                 @PathVariable("stop") String stopName,
                                                                 @PathVariable("bus") String bus


    ) {

        System.out.println(bus + " findCurrentStopTimetable " + stopName);
        return ResponseEntity.ok(transportSystemService.findTimetableByAreaAndStopName(area, stopName, bus));
    }

}
