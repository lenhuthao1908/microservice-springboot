package com.microservices.dto.request;

import com.microservices.common.MessageCommon;
import com.microservices.validator.DobConstraintValid;
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
    @Size(min = 3, message = MessageCommon.MINIMUM_3_CHARACTER)
    String username;
    @Size(min = 3, message = MessageCommon.MINIMUM_3_CHARACTER)
    String password;
    String firstName;
    String lastName;
    @DobConstraintValid(min = 18, message = MessageCommon.AGE_OLDER_THEN_18)
    LocalDate birthDate;
    
}
