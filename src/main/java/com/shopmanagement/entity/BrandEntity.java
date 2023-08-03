package com.shopmanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
/*@JsonIgnoreProperties({"hibernateLazyInitializer"})*/
@Table(name = "tbbrand")
public class BrandEntity {

    @Id
    @Column(name = "brandId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brandId;

    @Column(name = "brandName")
    private String brandName;

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "catId")
    private CategoryEntity catNameId;*/

    @Column(name = "categoryName")
    private String categoryName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id", referencedColumnName = "at_id")
    private AttachmentEntity attachmentEntity;




}
