package com.shopmanagement.dto.response;


import com.shopmanagement.entity.AttachmentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponse {

    private Long brandId;
    private String brandName;
    private String catNameId;
    private AttachmentEntity attachmentEntity;
}
