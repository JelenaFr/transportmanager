package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stop_times")
public class StopTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "time_id")
    private Integer id;
//    @Column (name = "trip_id")
//    private Trip tripId;
    @Column (name = "arrival_time")
    private Time arrivalTime;
    @Column (name = "departure_time")
    private Time departureTime;
    @Column (name = "stop_sequence")
    private Integer stopSequence;
    @Column (name = "pickup_type")
    private Integer pickupType;
    @Column (name = "drop_off_type")
    private Integer dropOffType;
//    @Column (name = "stop_id")
//    private Stop stopID;
    private Date time;

    @OneToMany
    @JoinColumn(name = "stop_id")
    private List<Stop> stops;

    @OneToMany
    @JoinColumn(name = "trip_id")
    private List<Trip> trips;





}
