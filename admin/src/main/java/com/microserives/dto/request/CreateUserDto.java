package com.microserives.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDto {
    @Size(min = 3, message = "Minimum three character")
    String username;
    @Size(min = 3, message = "Minimum three character")
    String password;
    String firstName;
    String lastName;
    LocalDate birthDate;
}
