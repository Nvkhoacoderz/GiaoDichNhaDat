package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDich;
import com.teamforone.giaodichnhadat.business.GiaoDichDat;
import com.teamforone.giaodichnhadat.business.GiaoDichNha;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToViewFindDTOConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for converting GiaoDich domain objects to GiaoDichViewFindDTO
 * Following Single Responsibility Principle
 */
public class GiaoDichToViewFindDTOConverterImpl implements GiaoDichToViewFindDTOConverter {
    
    @Override
    public GiaoDichViewFindDTO convert(GiaoDich giaoDich) {
        if (giaoDich == null) {
            return null;
        }
        
        GiaoDichViewFindDTO dto = new GiaoDichViewFindDTO();
        dto.maGiaoDich = giaoDich.getMaGiaoDich();
        dto.ngayGiaoDich = giaoDich.getNgayGiaoDich();
        dto.donGia = giaoDich.getDonGia();
        dto.dienTich = giaoDich.getDienTich();
        dto.loai = giaoDich.getLoai();
        dto.thanhTien = giaoDich.thanhTien();
        
        if (giaoDich instanceof GiaoDichNha) {
            dto.loaiGD = "nha";
            dto.loai = ((GiaoDichNha) giaoDich).getLoaiNha();
            dto.diaChi = ((GiaoDichNha) giaoDich).getDiaChi();
        } else if (giaoDich instanceof GiaoDichDat) {
            dto.loaiGD = "dat";
            dto.loai = ((GiaoDichDat) giaoDich).getLoaiDat();
            dto.diaChi = "";
        } else {
            dto.loaiGD = "";
            dto.loai = "";
            dto.diaChi = "";
        }
        
        return dto;
    }
    
    @Override
    public List<GiaoDichViewFindDTO> convertList(List<GiaoDich> giaoDichs) {
        if (giaoDichs == null) {
            return null;
        }
        
        List<GiaoDichViewFindDTO> dtos = new ArrayList<>();
        for (GiaoDich giaoDich : giaoDichs) {
            dtos.add(convert(giaoDich));
        }
        return dtos;
    }
}