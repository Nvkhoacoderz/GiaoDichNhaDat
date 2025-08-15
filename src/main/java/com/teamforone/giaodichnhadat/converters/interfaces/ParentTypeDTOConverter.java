package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.OpenAndEditForm.ResParentTypeDTO;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ParentTypeDTO;
import java.util.List;

/**
 * Interface for converting ParentTypeDTO to ResParentTypeDTO
 * Following Single Responsibility and Interface Segregation principles
 */
public interface ParentTypeDTOConverter {
    /**
     * Converts a ParentTypeDTO to ResParentTypeDTO
     * @param parentTypeDTO the DTO to convert
     * @return the converted response DTO
     */
    ResParentTypeDTO convert(ParentTypeDTO parentTypeDTO);
    
    /**
     * Converts a list of ParentTypeDTO to ResParentTypeDTO list
     * @param parentTypeDTOs the DTOs to convert
     * @return the converted response DTOs
     */
    List<ResParentTypeDTO> convertList(List<ParentTypeDTO> parentTypeDTOs);
}