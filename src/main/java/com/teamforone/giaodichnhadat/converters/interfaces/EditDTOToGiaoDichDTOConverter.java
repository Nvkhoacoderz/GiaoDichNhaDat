package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

/**
 * Interface for converting GiaoDichEditDTO to GiaoDichDTO
 * Following Single Responsibility and Interface Segregation principles
 */
public interface EditDTOToGiaoDichDTOConverter {
    /**
     * Converts a GiaoDichEditDTO to GiaoDichDTO
     * @param editDTO the edit DTO to convert
     * @return the converted DTO
     */
    GiaoDichDTO convert(GiaoDichEditDTO editDTO);
}