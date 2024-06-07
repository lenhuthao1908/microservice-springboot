package com.microservices.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * AbstractDate
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractDateDto {
    Long createdId;
    Date createdDate;
    Long updatedId;
    Date updatedDate;
    Long deletedId;
    Date deletedDate;
    Long approvedId;
    Date approvedDate;
}
