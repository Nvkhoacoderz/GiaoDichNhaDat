package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ViewFindDTOToViewItemConverter;
import com.teamforone.giaodichnhadat.presentation.GDViewFindItem;

import java.text.SimpleDateFormat;

/**
 * Implementation for converting GiaoDichViewFindDTO to GDViewFindItem
 * Following Single Responsibility Principle
 */
public class ViewFindDTOToViewItemConverterImpl implements ViewFindDTOToViewItemConverter {
    
    @Override
    public GDViewFindItem convert(GiaoDichViewFindDTO viewFindDTO) {
        if (viewFindDTO == null) {
            return null;
        }
        
        GDViewFindItem viewItem = new GDViewFindItem();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        
        viewItem.setMaGiaoDich(viewFindDTO.maGiaoDich);
        viewItem.setDiaChi(viewFindDTO.diaChi);
        viewItem.setNgayGiaoDich(fmt.format(viewFindDTO.ngayGiaoDich));
        viewItem.setLoaiGD(viewFindDTO.loaiGD);
        viewItem.setDonGia(String.format("%.2f", viewFindDTO.donGia));
        viewItem.setLoai(viewFindDTO.loai);
        viewItem.setThanhTien(String.format("%.2f", viewFindDTO.thanhTien));
        viewItem.setDienTich(String.format("%.2f", viewFindDTO.dienTich));
        
        return viewItem;
    }
}