package com.example.jewelry.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min=3,message = "USERNAME_INVALID")
    String username;
    @Size(min = 6,message = "PASSWORD_INVALID")
    String password;
    LocalDate dob;
}