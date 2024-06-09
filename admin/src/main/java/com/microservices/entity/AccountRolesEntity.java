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
 * AccountRolesEntity
 *
 * @author haoln
 * @version 01-00
 * @since 6/7/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ACCOUNT_ROLES")
public class AccountRolesEntity extends AbstractTracking {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACCOUNT_ID")
    private Long accountId;
    @Column(name = "ROLE_ID")
    private Long roleId;
}
