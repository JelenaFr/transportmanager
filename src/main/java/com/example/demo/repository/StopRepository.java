package com.example.demo.repository;

import com.example.demo.entity.Stop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends CrudRepository<Stop, Integer> {
    @Query("SELECT DISTINCT a.stopArea FROM Stop a")
    List<String> findUniqueStopAreas();


    @Query("SELECT DISTINCT a.stopName FROM Stop a WHERE a.stopArea = ?1")
    List<String> findStopsByStopArea(String areaInput);


}


