package com.teamforone.giaodichnhadat.converters.interfaces;

import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.presentation.GDViewFindItem;
import java.util.List;

/**
 * Interface for converting List<GiaoDichViewFindDTO> to List<GDViewFindItem>
 * Following Single Responsibility and Interface Segregation principles
 */
public interface ViewFindDTOListToViewItemListConverter {
    /**
     * Converts a list of GiaoDichViewFindDTO to list of GDViewFindItem for presentation
     * @param viewFindDTOs the DTOs to convert
     * @return the converted view items
     */
    List<GDViewFindItem> convert(List<GiaoDichViewFindDTO> viewFindDTOs);
}