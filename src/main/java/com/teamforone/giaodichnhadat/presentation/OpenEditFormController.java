package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.business.OpenEditFormUseCase;


public class OpenEditFormController {
    private GiaoDichEditModel model;
    private OpenEditFormUseCase useCase;

    public OpenEditFormController(GiaoDichEditModel model, OpenEditFormUseCase useCase) {
        this.model = model;
        this.useCase = useCase;
    }

    public void openEditForm(String maGiaoDich) {
        try {
            GiaoDichEditDTO items = useCase.openEditForm(maGiaoDich);
            GiaoDichEditItem viewItems = convertToViewModel(items);
            model.listItem  = viewItems;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GiaoDichEditItem convertToViewModel(GiaoDichEditDTO dto) {
        GiaoDichEditItem item = new GiaoDichEditItem();
        item.setMaGiaoDich(dto.maGiaoDich);
        item.setNgayGiaoDich(dto.ngayGiaoDich.toString());
        item.setDonGia(String.format("%.2f", dto.donGia));
        item.setLoai(dto.loaiGD);
        item.setDiaChi(dto.diaChi);
        item.setDienTich(String.format("%.2f", dto.dienTich));
        item.setLoaiNha(dto.loaiNha);
        item.setLoaiDat(dto.loaiDat);
        return item;
    }
}
