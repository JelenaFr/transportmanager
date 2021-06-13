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
    @Column (name = "route_id" )
    private String id;
    private Integer agencyId;
    private String routShortName;
    private String routLongName;
    private Integer routType;
    private String routColor;
    private String competent_authority;
    private Date timestamp;



}
