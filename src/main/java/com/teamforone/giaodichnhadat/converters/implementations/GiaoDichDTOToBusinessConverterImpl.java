package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.business.GiaoDichEditFactory;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichDTOToBusinessConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for converting GiaoDichDTO to GiaoDich domain objects
 * Following Single Responsibility Principle
 */
public class GiaoDichDTOToBusinessConverterImpl implements GiaoDichDTOToBusinessConverter {
    
    @Override
    public GiaoDich convert(GiaoDichDTO dto) {
        if (dto == null) {
            return null;
        }
        
        // Use existing factory to maintain consistency
        return GiaoDichEditFactory.createGiaoDich(dto);
    }
    
    @Override
    public List<GiaoDich> convertList(List<GiaoDichDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        
        List<GiaoDich> giaoDichs = new ArrayList<>();
        for (GiaoDichDTO dto : dtos) {
            GiaoDich giaoDich = convert(dto);
            if (giaoDich != null) {
                giaoDichs.add(giaoDich);
            }
        }
        return giaoDichs;
    }
}