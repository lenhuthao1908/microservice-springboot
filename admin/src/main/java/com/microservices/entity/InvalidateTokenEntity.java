package com.microservices.entity;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * InvalidateTokenEntity
 *
 * @author haoln
 * @version 01-00
 * @since 6/4/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "INVALIDATE_TOKEN")
public class InvalidateTokenEntity {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "EXPIRY_TIME")
    private Date expiryTime;
}
