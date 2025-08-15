package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.OpenAndEditForm.ResChildrenTypeDTO;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ChildrenTypeDTO;
import java.util.List;

/**
 * Interface for converting ChildrenTypeDTO to ResChildrenTypeDTO
 * Following Single Responsibility and Interface Segregation principles
 */
public interface ChildrenTypeDTOConverter {
    /**
     * Converts a ChildrenTypeDTO to ResChildrenTypeDTO
     * @param childrenTypeDTO the DTO to convert
     * @return the converted response DTO
     */
    ResChildrenTypeDTO convert(ChildrenTypeDTO childrenTypeDTO);
    
    /**
     * Converts a list of ChildrenTypeDTO to ResChildrenTypeDTO list
     * @param childrenTypeDTOs the DTOs to convert
     * @return the converted response DTOs
     */
    List<ResChildrenTypeDTO> convertList(List<ChildrenTypeDTO> childrenTypeDTOs);
}