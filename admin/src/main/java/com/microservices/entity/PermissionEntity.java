package com.microservices.entity;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

/**
 * PermissionEntity
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "PERMISSION")
public class PermissionEntity extends AbstractTracking {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    @Column(name = "PERMISSION_DESCRIPTION")
    private String permissionDescription;
}
