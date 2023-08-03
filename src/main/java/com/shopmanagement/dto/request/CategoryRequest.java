package com.shopmanagement.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryRequest {


    private Long catId;
    private String categoryName;
    private String categoryDesc;
    private Date addingDate;


    public Date getAddingDate(){
        return new Date();
    }
}
