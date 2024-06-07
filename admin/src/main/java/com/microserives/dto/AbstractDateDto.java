package com.microserives.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
