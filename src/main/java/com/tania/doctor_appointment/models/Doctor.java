package com.tania.doctor_appointment.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "doctors")
public class Doctor {

    @Id
    private String id;

    @Field("userId")
    private String userId;

    @Indexed(unique = true)
    @Field("licenseNumber")
    private String licenseNumber;


    @Field("specialities")
    private List<String> specialities;

    @Field("doctorsDocuments")
    private List<DoctorsDocument> doctorsDocuments;

    @Field("yearsOfExperience")
    private Integer yearsOfExperience;

    @Field("bio")
    private String bio;

    @GeoSpatialIndexed
    @Field("clinicLocations")
    private List<GeoJsonPoint> clinicLocations;

    @Field("hospitals")
    private List<String> hospitals;

    @Field("services")
    private List<Service>services;

    @Field("reviewCount")
    private Integer reviewCount;

    @Field("avgRating")
    private Double avgRating;
}

