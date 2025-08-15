package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.presentation.GDViewFindItem;

/**
 * Interface for converting GiaoDichViewFindDTO to GDViewFindItem
 * Following Single Responsibility and Interface Segregation principles
 */
public interface ViewFindDTOToViewItemConverter {
    /**
     * Converts a GiaoDichViewFindDTO to GDViewFindItem for presentation
     * @param viewFindDTO the DTO to convert
     * @return the converted view item
     */
    GDViewFindItem convert(GiaoDichViewFindDTO viewFindDTO);
}