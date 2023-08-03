package com.shopmanagement.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbcategory")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catId")
    private Long catId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "CategoryDesc")
    private String categoryDesc;

    @Column(name = "addingDate")
    private Date addingDate;
}
