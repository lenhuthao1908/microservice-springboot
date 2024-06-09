package com.microservices.dto.request;

import com.microservices.common.MessageCommon;
import com.microservices.validator.DobConstraintValid;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountDto {
    String username;
    String password;
    String firstName;
    String lastName;
    Date birthDate;
    
}
