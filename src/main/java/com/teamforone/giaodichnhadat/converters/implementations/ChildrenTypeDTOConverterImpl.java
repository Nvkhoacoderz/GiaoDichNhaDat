package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.OpenAndEditForm.ResChildrenTypeDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ChildrenTypeDTOConverter;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ChildrenTypeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for converting ChildrenTypeDTO to ResChildrenTypeDTO
 * Following Single Responsibility Principle
 */
public class ChildrenTypeDTOConverterImpl implements ChildrenTypeDTOConverter {
    
    @Override
    public ResChildrenTypeDTO convert(ChildrenTypeDTO childrenTypeDTO) {
        if (childrenTypeDTO == null) {
            return null;
        }
        
        ResChildrenTypeDTO resDTO = new ResChildrenTypeDTO();
        resDTO.id = childrenTypeDTO.id;
        resDTO.name = childrenTypeDTO.name;
        resDTO.description = childrenTypeDTO.description;
        resDTO.parentId = childrenTypeDTO.parentId;
        
        return resDTO;
    }
    
    @Override
    public List<ResChildrenTypeDTO> convertList(List<ChildrenTypeDTO> childrenTypeDTOs) {
        if (childrenTypeDTOs == null) {
            return null;
        }
        
        List<ResChildrenTypeDTO> resList = new ArrayList<>();
        for (ChildrenTypeDTO dto : childrenTypeDTOs) {
            ResChildrenTypeDTO resDTO = convert(dto);
            if (resDTO != null) {
                resList.add(resDTO);
            }
        }
        
        return resList;
    }
}