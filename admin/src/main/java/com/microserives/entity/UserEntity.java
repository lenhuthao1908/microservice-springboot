package com.microserives.entity;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "USER_INFO")
public class UserEntity extends AbstractKing {
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "USERNAME")
    String username;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "FIRST_NAME")
    String firstName;
    @Column(name = "LAST_NAME")
    String lastName;
    @Column(name = "BIRTH_DATE")
    LocalDate birthDate;
    @Column(name = "ROLE")
    List<RoleEntity> roles;
}
