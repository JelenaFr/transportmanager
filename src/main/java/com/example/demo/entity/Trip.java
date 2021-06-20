package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "trip_id")
    private Integer id;
    @Column (name = "trip_headsign")
    private String tripHeadSign;
    @Column (name = "trip_long_name")
    private String tripLongName;
    @Column (name = "direction_code")
    private Integer directionCode;
    @Column (name = "shape_id")
    private Integer shapeId;
    @Column (name = "wheelchair_accessible")
    private Integer wheelchairAccessible;
    @Column (name = "service_id")
    private Integer serviceId;
    private Date time;

    @OneToMany
    @JoinColumn(name = "route_id")
    private List<Route> routes;

}
