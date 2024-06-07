package com.microservices.entity;

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

/**
 * PermissionEntity
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "PERMISSION")
public class PermissionEntity extends AbstractKing{
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "PERMISSION_NAME")
    String permissionName;
    @Column(name = "PERMISSION_DESCRIPTION")
    String permissionDescription;
}
