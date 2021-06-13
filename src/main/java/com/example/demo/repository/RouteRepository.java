package com.example.demo.repository;

import com.example.demo.entity.Route;
import com.example.demo.entity.Stop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {
}

