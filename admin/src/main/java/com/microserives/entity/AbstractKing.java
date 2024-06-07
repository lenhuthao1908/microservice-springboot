package com.microserives.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
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
