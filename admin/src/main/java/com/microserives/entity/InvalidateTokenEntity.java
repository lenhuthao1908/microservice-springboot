package com.microserives.entity;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "INVALIDATE_TOKEN")
public class InvalidateTokenEntity {
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "CODE")
    String code;
    @Column(name = "EXPIRY_TIME")
    Date expiryTime;
}
