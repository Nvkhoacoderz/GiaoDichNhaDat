package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.business.GiaoDichDat;
import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.business.GiaoDichNha;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToEditDTOConverter;

/**
 * Implementation for converting GiaoDich domain objects to GiaoDichEditDTO
 * Following Single Responsibility Principle
 */
public class GiaoDichToEditDTOConverterImpl implements GiaoDichToEditDTOConverter {
    
    @Override
    public GiaoDichEditDTO convert(GiaoDich giaoDich) {
        if (giaoDich == null) {
            return null;
        }
        
        GiaoDichEditDTO dto = new GiaoDichEditDTO();
        dto.maGiaoDich = giaoDich.getMaGiaoDich();
        dto.ngayGiaoDich = giaoDich.getNgayGiaoDich();
        dto.donGia = giaoDich.getDonGia();
        dto.loaiGD = giaoDich.getLoai();
        dto.dienTich = giaoDich.getDienTich();
        
        if (giaoDich instanceof GiaoDichNha) {
            dto.loaiNha = ((GiaoDichNha) giaoDich).getLoaiNha();
            dto.diaChi = ((GiaoDichNha) giaoDich).getDiaChi();
            dto.loaiDat = "";
        } else if (giaoDich instanceof GiaoDichDat) {
            dto.loaiDat = ((GiaoDichDat) giaoDich).getLoaiDat();
            dto.loaiNha = "";
            dto.diaChi = "";
        } else {
            dto.loaiNha = "";
            dto.loaiDat = "";
            dto.diaChi = "";
        }
        
        return dto;
    }
}