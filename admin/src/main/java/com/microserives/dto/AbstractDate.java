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
public abstract class AbstractDate {
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
}
