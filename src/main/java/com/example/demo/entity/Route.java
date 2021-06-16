package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "routes")
public class Route {
    @Id
    @Column (name = "route_id")
    private String id;
    @Column (name = "agency_id")
    private Integer agencyId;
    @Column (name = "route_short_Name")
    private String routeShortName;
    @Column (name = "route_long_Name")
    private String routeLongName;
    @Column (name = "route_type")
    private Integer routeType;
    @Column (name = "route_color")
    private String routeColor;
    @Column (name = "competent_authority")
    private String competentAuthority;
    private Date time;



}
