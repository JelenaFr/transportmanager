package com.example.demo.repository;

import com.example.demo.entity.Stop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends CrudRepository<Stop, Integer> {
    @Query("SELECT DISTINCT a.stopArea FROM Stop a")
    List<String> findUniqueStopAreas();


    @Query("SELECT DISTINCT a.stopName FROM Stop a WHERE a.stopArea = ?1")
    List<String> findStopsByStopArea(String areaInput);

    @Query("SELECT a.stopName, a.stopLatitude, a.stopLongitude, a.stopArea FROM Stop a WHERE  a.stopLatitude between :minLatitude and :maxLatitude and a.stopLongitude between :minLongitude and :maxLongitude")
    List<String>  findStopsByLocation (Double minLatitude, Double minLongitude, Double maxLatitude, Double maxLongitude);
}


