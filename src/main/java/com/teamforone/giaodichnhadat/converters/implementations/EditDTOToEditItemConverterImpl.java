package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.EditDTOToEditItemConverter;
import com.teamforone.giaodichnhadat.presentation.GiaoDichEditItem;

/**
 * Implementation for converting GiaoDichEditDTO to GiaoDichEditItem
 * Following Single Responsibility Principle
 */
public class EditDTOToEditItemConverterImpl implements EditDTOToEditItemConverter {
    
    @Override
    public GiaoDichEditItem convert(GiaoDichEditDTO editDTO) {
        if (editDTO == null) {
            return null;
        }
        
        GiaoDichEditItem item = new GiaoDichEditItem();
        item.setMaGiaoDich(editDTO.maGiaoDich);
        item.setNgayGiaoDich(editDTO.ngayGiaoDich.toString());
        item.setDonGia(String.format("%.2f", editDTO.donGia));
        item.setLoai(editDTO.loaiGD);
        item.setDiaChi(editDTO.diaChi);
        item.setDienTich(String.format("%.2f", editDTO.dienTich));
        item.setLoaiNha(editDTO.loaiNha);
        item.setLoaiDat(editDTO.loaiDat);
        
        return item;
    }
}