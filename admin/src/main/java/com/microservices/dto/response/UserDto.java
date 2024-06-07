package com.microservices.dto.response;

import com.microservices.dto.AbstractDateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
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
    Set<RoleDto> roles;
}
