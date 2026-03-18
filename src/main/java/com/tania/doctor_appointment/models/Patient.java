package com.tania.doctor_appointment.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "patients")
public class Patient {

    @Id
    private String id;

    @Indexed
    @Field("userId")
    private String userId;

    @Field("medicalDocuments")
    private List<String> medicalDocuments;

    @Field("insuranceNumber")
    private String insuranceNumber;

}
