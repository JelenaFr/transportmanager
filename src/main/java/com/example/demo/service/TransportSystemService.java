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

        public List<String> findUniqueStopAreas(){
        return stopRepository.findUniqueStopAreas().stream().sorted().collect(Collectors.toList());
    }

    public List<String> findallStopsThisArea(String area) {
        stopRepository.findStopsByStopArea(area).forEach(System.out::println);
        return stopRepository.findStopsByStopArea(area).stream().sorted().collect(Collectors.toList());
    }

    public List<String> findAllBusesByUserQuery(String s) {
        routeRepository.findAllBusesByUserQuery(s).forEach(System.out::println);
        return routeRepository.findAllBusesByUserQuery(s).stream().distinct().sorted().collect(Collectors.toList());
    }

}
