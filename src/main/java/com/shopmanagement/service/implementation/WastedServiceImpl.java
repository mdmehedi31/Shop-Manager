package com.shopmanagement.service.implementation;

import com.shopmanagement.dto.request.WastedRequest;
import com.shopmanagement.dto.response.WastedResponse;
import com.shopmanagement.entity.WastedEntity;
import com.shopmanagement.service.Definition.WastedServiceDefinition;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WastedServiceImpl implements WastedServiceDefinition {
    @Override
    public List<WastedResponse> getAllWasted() {
        return null;
    }

    @Override
    public void addCategory(WastedRequest wastedRequest) {

    }

    @Override
    public WastedEntity dtoToEntity(WastedRequest wastedRequest) {
        return null;
    }

    @Override
    public WastedResponse entityToDto(WastedEntity wastedEntity) {
        return null;
    }
}
