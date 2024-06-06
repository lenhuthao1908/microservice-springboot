package com.microserives.entity;

import com.miragesql.miragesql.annotation.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractKing {
    @Column(name = "CREATED_ID")
    Long createdId;
    @Column(name = "CREATED_DATE")
    Date createdDate;
    @Column(name = "UPDATED_ID")
    Long updatedId;
    @Column(name = "UPDATED_DATE")
    Date updatedDate;
    @Column(name = "DELETED_ID")
    Long deletedId;
    @Column(name = "DELETED_DATE")
    Date deletedDate;
    @Column(name = "APPROVED_ID")
    Long approvedId;
    @Column(name = "APPROVED_DATE")
    Date approvedDate;
}
