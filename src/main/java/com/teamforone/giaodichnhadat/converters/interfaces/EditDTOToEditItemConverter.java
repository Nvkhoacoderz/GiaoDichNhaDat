package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.presentation.GiaoDichEditItem;

/**
 * Interface for converting GiaoDichEditDTO to GiaoDichEditItem
 * Following Single Responsibility and Interface Segregation principles
 */
public interface EditDTOToEditItemConverter {
    /**
     * Converts a GiaoDichEditDTO to GiaoDichEditItem for presentation
     * @param editDTO the DTO to convert
     * @return the converted presentation item
     */
    GiaoDichEditItem convert(GiaoDichEditDTO editDTO);
}