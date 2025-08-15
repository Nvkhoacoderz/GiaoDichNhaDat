package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;
import java.util.List;

/**
 * Interface for converting GiaoDichDTO to GiaoDich domain objects
 * Following Single Responsibility and Interface Segregation principles
 */
public interface GiaoDichDTOToBusinessConverter {
    /**
     * Converts a GiaoDichDTO to GiaoDich domain object
     * @param dto the DTO to convert
     * @return the converted domain object
     */
    GiaoDich convert(GiaoDichDTO dto);
    
    /**
     * Converts a list of GiaoDichDTO to GiaoDich domain objects
     * @param dtos the DTOs to convert
     * @return the converted domain objects
     */
    List<GiaoDich> convertList(List<GiaoDichDTO> dtos);
}