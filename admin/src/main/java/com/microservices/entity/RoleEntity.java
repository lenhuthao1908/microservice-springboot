package com.microservices.entity;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

/**
 * RoleEntity
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "ROLE")
public class RoleEntity extends AbstractTracking {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
}
