package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;

/**
 * Interface for converting GiaoDich domain objects to GiaoDichEditDTO
 * Following Single Responsibility and Interface Segregation principles
 */
public interface GiaoDichToEditDTOConverter {
    /**
     * Converts a GiaoDich domain object to GiaoDichEditDTO
     * @param giaoDich the domain object to convert
     * @return the converted DTO
     */
    GiaoDichEditDTO convert(GiaoDich giaoDich);
}