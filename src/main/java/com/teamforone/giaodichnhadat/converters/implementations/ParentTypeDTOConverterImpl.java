package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.OpenAndEditForm.ResParentTypeDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ParentTypeDTOConverter;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ParentTypeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for converting ParentTypeDTO to ResParentTypeDTO
 * Following Single Responsibility Principle
 */
public class ParentTypeDTOConverterImpl implements ParentTypeDTOConverter {
    
    @Override
    public ResParentTypeDTO convert(ParentTypeDTO parentTypeDTO) {
        if (parentTypeDTO == null) {
            return null;
        }
        
        ResParentTypeDTO resDTO = new ResParentTypeDTO();
        resDTO.id = parentTypeDTO.id;
        resDTO.name = parentTypeDTO.name;
        resDTO.description = parentTypeDTO.description;
        
        return resDTO;
    }
    
    @Override
    public List<ResParentTypeDTO> convertList(List<ParentTypeDTO> parentTypeDTOs) {
        if (parentTypeDTOs == null) {
            return null;
        }
        
        List<ResParentTypeDTO> resList = new ArrayList<>();
        for (ParentTypeDTO dto : parentTypeDTOs) {
            ResParentTypeDTO resDTO = convert(dto);
            if (resDTO != null) {
                resList.add(resDTO);
            }
        }
        
        return resList;
    }
}