package com.example.demo.repository;

import com.example.demo.entity.Stop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopTimeRepository extends CrudRepository<Stop, Integer> {
    @Query(nativeQuery = true, value = " SELECT  direction_code, arrival_time  FROM stop_times \n" +
            "            LEFT JOIN stops on stops.stop_id = stop_times.stop_id  \n" +
            "            LEFT JOIN trips on trips.trip_id = stop_times.trip_id \n" +
            "            LEFT JOIN routes on routes.route_id = trips.route_id \n" +
            "            WHERE stop_times.departure_time > CURRENT_TIME and stops.stop_name =:stopInput and routes.route_short_name =:busInput \n" +
            "            ORDER BY stop_times.departure_time ASC ;")
    List<String> timetableByAreaByStopNameByBusNumber(String stopInput, String busInput);
}