package com.microservices.entity;

import com.miragesql.miragesql.annotation.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AbstractTracking {
    @Column(name = "CREATED_ID")
    private Long createdId;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "UPDATED_ID")
    private Long updatedId;
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
    @Column(name = "DELETED_ID")
    private Long deletedId;
    @Column(name = "DELETED_DATE")
    private Date deletedDate;
    @Column(name = "APPROVED_ID")
    private Long approvedId;
    @Column(name = "APPROVED_DATE")
    private Date approvedDate;
}
