package com.tania.doctor_appointment.models;

import com.tania.doctor_appointment.enums.Gender;
import com.tania.doctor_appointment.enums.Role;
import com.tania.doctor_appointment.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")

public class User extends Audit {

    @Id
    private String id;

    @Field("fullName")
    private String fullName;

    @Indexed(unique = true)
    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Indexed(unique = true)
    @Field("phoneNumber")
    private String phoneNumber;

    @Field("role")
    private Role role;

    @Field("avatarUrl")
    private String avatarUrl;

    @Field("gender")
    private Gender gender;

    @Field("dataOfBirth")
    private LocalDate dateOfBirth;

    @Field("status")
    private Status status;
}
