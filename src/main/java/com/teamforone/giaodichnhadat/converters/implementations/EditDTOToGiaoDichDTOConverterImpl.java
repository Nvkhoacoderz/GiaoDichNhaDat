package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.EditDTOToGiaoDichDTOConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

/**
 * Implementation for converting GiaoDichEditDTO to GiaoDichDTO
 * Following Single Responsibility Principle
 */
public class EditDTOToGiaoDichDTOConverterImpl implements EditDTOToGiaoDichDTOConverter {
    
    @Override
    public GiaoDichDTO convert(GiaoDichEditDTO editDTO) {
        if (editDTO == null) {
            return null;
        }
        
        GiaoDichDTO dto = new GiaoDichDTO();
        dto.maGiaoDich = editDTO.maGiaoDich;
        dto.ngayGiaoDich = editDTO.ngayGiaoDich;
        dto.donGia = editDTO.donGia;
        dto.loaiGiaoDich = editDTO.loaiGD;
        dto.dienTich = editDTO.dienTich;
        dto.diaChi = editDTO.diaChi;
        dto.loaiNha = editDTO.loaiNha;
        dto.loaiDat = editDTO.loaiDat;
        
        return dto;
    }
}