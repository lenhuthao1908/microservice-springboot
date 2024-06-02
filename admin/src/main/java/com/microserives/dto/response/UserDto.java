package com.microserives.dto.response;

import com.microserives.dto.AbstractDateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto extends AbstractDateDto {
    Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate birthDate;
    List<String> roles;
}
