package com.teamforone.giaodichnhadat.converters.implementations;

import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ViewFindDTOListToViewItemListConverter;
import com.teamforone.giaodichnhadat.presentation.GDViewFindItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for converting List<GiaoDichViewFindDTO> to List<GDViewFindItem>
 * Following Single Responsibility Principle
 */
public class ViewFindDTOListToViewItemListConverterImpl implements ViewFindDTOListToViewItemListConverter {
    
    @Override
    public List<GDViewFindItem> convert(List<GiaoDichViewFindDTO> viewFindDTOs) {
        if (viewFindDTOs == null) {
            return null;
        }
        
        List<GDViewFindItem> viewItems = new ArrayList<>();
        for (GiaoDichViewFindDTO item : viewFindDTOs) {
            GDViewFindItem viewItem = new GDViewFindItem();
            viewItem.setMaGiaoDich(item.maGiaoDich);
            viewItem.setDiaChi(item.diaChi);
            viewItem.setNgayGiaoDich(item.ngayGiaoDich.toString());
            viewItem.setLoaiGD(item.loaiGD);
            viewItem.setDonGia(String.format("%.2f", item.donGia));
            viewItem.setLoai(item.loai);
            viewItem.setThanhTien(String.format("%.2f", item.thanhTien));
            viewItem.setDienTich(String.format("%.2f", item.dienTich));
            viewItems.add(viewItem);
        }
        
        return viewItems;
    }
}