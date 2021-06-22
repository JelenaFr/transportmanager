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

@Table(name = "stops")
public class Stop {
    @Id
    @Column (name = "stop_id")
    private Integer id;
    @Column (name = "stop_code")
    private String stopCode;
    @Column (name = "stop_name")
    private String stopName;
    @Column (name = "stop_lon")
    private Double stopLongitude;
    @Column (name = "stop_lat")
    private Double stopLatitude;
    @Column (name = "zone_id")
    private Integer zoneId;
    @Column (name = "stop_area" )
    private String stopArea;
    @Column (name = "stop_desc" )
    private String stopDesc;
    @Column (name = "lest_X" )
    private Float lestX;
    @Column (name = "lest_Y" )
    private Float lestY;
    @Column (name = "zone_name" )
    private String zoneName;
    private String alias;
    private Date time;
}
