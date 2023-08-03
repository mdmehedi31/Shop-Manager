package com.shopmanagement.service.Definition;

import com.shopmanagement.dto.request.CategoryRequest;
import com.shopmanagement.dto.request.WastedRequest;
import com.shopmanagement.dto.response.CategoryResponse;
import com.shopmanagement.dto.response.WastedResponse;
import com.shopmanagement.entity.CategoryEntity;
import com.shopmanagement.entity.WastedEntity;

import java.util.List;

public interface WastedServiceDefinition {

    List<WastedResponse> getAllWasted();

    void addCategory(WastedRequest wastedRequest);

    WastedEntity dtoToEntity(WastedRequest wastedRequest);

    WastedResponse entityToDto(WastedEntity wastedEntity);



}
