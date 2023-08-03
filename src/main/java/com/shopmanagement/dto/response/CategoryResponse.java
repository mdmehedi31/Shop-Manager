package com.shopmanagement.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryResponse {


    private Long catId;
    private String categoryName;
    private String categoryDesc;
    private Date addingDate;
}
