package com.microserives.dto;

import lombok.Getter;
import lombok.Setter;

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
public abstract class AbstractDateDto {
    private Long createdId;
    private Date createdDate;
    private Long updatedId;
    private Date updatedDate;
    private Long deletedId;
    private Date deletedDate;
    private Long approvedId;
    private Date approvedDate;
}
