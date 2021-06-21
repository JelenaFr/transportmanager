package com.example.demo.service;

import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.StopRepository;
import com.example.demo.repository.StopTimeRepository;
import com.example.demo.repository.TripRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<String> findUniqueStopAreas() {
        return stopRepository.findUniqueStopAreas().stream().sorted().collect(Collectors.toList());
    }

    public List<String> findallStopsByArea(String area) {
        return stopRepository.findStopsByStopArea(area).stream().sorted().collect(Collectors.toList());
    }

    public List<String> findAllBusesByUserQuery(String areaInput, String stopInput) {
        return routeRepository.findAllBusesByUserQuery(areaInput, stopInput).stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public Double findDistanceBetweenStops(Double lat1, Double lng1, Double lat2, Double lng2) {
        Double earthRadius = 6371000.00; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        val dist = earthRadius * c;

        return dist;
    }

    public String findNearestStopsByLocation(Double userLatitude, Double userLongitude) {
        Double minLatitude = userLatitude - (10 / 111.122);
        Double minLongitude = userLongitude - (10 / 111.12);
        Double maxLatitude = userLatitude + (10 / 111.122);
        Double maxLongitude = userLongitude + (10 / 111.12);

        List<String> listWithAllNearestStops = stopRepository.findStopsByLocation(minLatitude, minLongitude, maxLatitude, maxLongitude);
        Map<Double, String> map = new HashMap<>();
        List<String[]> arrList = new ArrayList<>();

        for (String s : listWithAllNearestStops) {
            arrList.add(s.split(","));
        }
        for (String[] strings : arrList) {
            Double distance = findDistanceBetweenStops(userLatitude, userLongitude, Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
            map.put(distance, strings[0]);
        }

        String nearestStop = map.entrySet().stream().min(Comparator.comparingDouble(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .get();

        return nearestStop;
    }

    public List<List<String>> findTimetableByAreaByStopNameByBusNumber(String stop, String bus) {
        List<String> list = stopTimeRepository.timetableByAreaByStopNameByBusNumber(stop, bus);
        List<String> forward = list.stream().filter((string) -> string.startsWith("A"))
                .map((string) -> string.substring(string.indexOf(",") + 1))
               //.distinct()
                .limit(5)
                .collect(Collectors.toList());

        List<String> back = list.stream().filter((string) -> !string.startsWith("A"))
                .map((string) -> string.substring(string.indexOf(",") + 1))
               // .distinct()
                .limit(5)
                .collect(Collectors.toList());


        List<List<String>> total = new ArrayList();
        total.add(forward);
        total.add(back);
        total.forEach(System.out::println);
        return total;
    }
}
