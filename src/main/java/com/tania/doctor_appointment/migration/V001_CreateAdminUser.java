package com.tania.doctor_appointment.migration;


import com.tania.doctor_appointment.enums.*;
import com.tania.doctor_appointment.models.User;
import io.mongock.api.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChangeUnit(id = "001-create-admin-user", order = "001", author = "tania")
@RequiredArgsConstructor
public class V001_CreateAdminUser {
    private static final Logger log =
            LoggerFactory.getLogger(V001_CreateAdminUser.class);

    @Execution
    public void execute(MongoTemplate mongoTemplate, PasswordEncoder passwordEncoder) {

        log.info("Starting admin migration...");
        Query query = Query.query(Criteria.where("email").is("admin@example.com"));

        boolean exists = mongoTemplate.exists(query, User.class);

        if (!exists) {
            log.debug("Admin not found → creating new admin");
            User admin = User.builder()
                    .fullName("System Admin")
                    .email("admin@example.com")
                    .phoneNumber("0000000000")
                    .password(passwordEncoder.encode("admin123"))   // later we will hash
                    .role(Role.ADMIN)
                    .status(Status.APPROVED)
                    .build();

            mongoTemplate.save(admin);

            log.info("✅ Admin user created by Mongock migration");
        } else {
            log.warn("⚠️ Admin already exists — skipping migration logic");
        }
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        log.warn("⚠️ Rolling back admin migration...");
        Query query = Query.query(Criteria.where("email").is("admin@example.com"));
        mongoTemplate.remove(query, User.class);

        log.info("↩️ Admin migration rolled back");
    }
}