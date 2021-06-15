package com.example.demo.service;

import com.example.demo.entity.Stop;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.StopRepository;
import com.example.demo.repository.StopTimeRepository;
import com.example.demo.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportSystemService {
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StopTimeRepository stopTimeRepository;
    @Autowired
    private TripRepository tripRepository;

    Location location = new Location();
    String userIP = location.findUserIpAddress();
    //location.findUserCoordinate(userIP).forEach(System.out::println);

    public Iterable<Stop> findAllDistricts() {
        return stopRepository.findAll();
    }


    public List<String> findUniqueStopAreas(){
        return stopRepository.findUniqueStopAreas().stream().sorted().collect(Collectors.toList());
    }

    public List<String> findallStopsThisArea(String s) {
        stopRepository.findStopsByStopArea(s).forEach(System.out::println);
        return stopRepository.findStopsByStopArea(s);
    }

//    public Iterable<Object> findUserStops() {
//    }
}
