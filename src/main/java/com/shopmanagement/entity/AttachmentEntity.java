package com.shopmanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "tbattachment")
@Builder
public class AttachmentEntity {

    public AttachmentEntity(Long atId, String attachmentName, String attachmentPath, String attachmentType) {
        this.atId = atId;
        this.attachmentName = attachmentName;
        this.attachmentPath = attachmentPath;
        this.attachmentType = attachmentType;
    }

    public AttachmentEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "at_id", nullable=false)
    private Long atId;

    @Column(name="attachment_name", length=1024)
    private String attachmentName;

    @Column(name = "attachment_path", length=1024)
    private  String attachmentPath;

    @Column(name = "attachment_type", length=1024)
    private String attachmentType;


}
