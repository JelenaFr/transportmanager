package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tripHeadSign;
    private String tripLongName;
    private Integer directionCode;
    private Integer shapeId;
    private Integer wheelchairAccessible;
    private Date timestamp;
    private Integer serviceId;
    private String routeId;



}
