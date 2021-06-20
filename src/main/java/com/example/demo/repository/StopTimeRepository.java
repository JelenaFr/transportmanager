package com.example.demo.repository;

import com.example.demo.entity.Stop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopTimeRepository extends CrudRepository<Stop, Integer> {


}