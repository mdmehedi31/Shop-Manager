package com.shopmanagement.dto.request;



import com.shopmanagement.entity.AttachmentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequest {

    private Long brandId;
    private String brandName;
    private String categoryName;

    private AttachmentEntity attachmentEntity;



   /* @JsonProperty("CatNameId")
    public void setCatNameId(CatNameId catId) {

     this.catNameId=catId.toString();
    }*/
}
