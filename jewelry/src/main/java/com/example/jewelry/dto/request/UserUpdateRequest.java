package com.example.jewelry.dto.request;

import com.example.jewelry.validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String username;
    String password;

    @DobConstraint(min=18,message = "INVALID_DOB")
    LocalDate dob;
    List<String> roles;
}
