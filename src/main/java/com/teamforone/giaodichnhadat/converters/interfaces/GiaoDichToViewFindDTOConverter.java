package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import java.util.List;

/**
 * Interface for converting GiaoDich domain objects to GiaoDichViewFindDTO
 * Following Single Responsibility and Interface Segregation principles
 */
public interface GiaoDichToViewFindDTOConverter {
    /**
     * Converts a single GiaoDich domain object to GiaoDichViewFindDTO
     * @param giaoDich the domain object to convert
     * @return the converted DTO
     */
    GiaoDichViewFindDTO convert(GiaoDich giaoDich);
    
    /**
     * Converts a list of GiaoDich domain objects to GiaoDichViewFindDTO list
     * @param giaoDichs the list of domain objects to convert
     * @return the converted DTO list
     */
    List<GiaoDichViewFindDTO> convertList(List<GiaoDich> giaoDichs);
}