package com.example.demo.repository;

import com.example.demo.entity.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT routes.route_short_name FROM routes " +
            "LEFT JOIN trips on routes.route_id = trips.route_id " +
            "LEFT JOIN stop_times on trips.trip_id = stop_times.trip_id " +
            "LEFT JOIN stops on stop_times.stop_id = stops.stop_id WHERE stops.stop_area = :areaInput and stops.stop_name = :stopInput")
    List<String> findAllBusesByUserQuery(String areaInput, String stopInput);
}

