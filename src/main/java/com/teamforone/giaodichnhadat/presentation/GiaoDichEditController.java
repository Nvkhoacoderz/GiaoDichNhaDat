package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.business.GiaoDichEditUC;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class GiaoDichEditController {
    private GiaoDichEditModel giaoDichEditModel;
    private GiaoDichEditUC giaoDichEditUC;

    public GiaoDichEditController(GiaoDichEditModel giaoDichEditModel, GiaoDichEditUC giaoDichEditUC) {
        this.giaoDichEditModel = giaoDichEditModel;
        this.giaoDichEditUC = giaoDichEditUC;
    }

    private GiaoDichEditItem convertToPresent(GiaoDichEditDTO dto){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

    public void editGD(GiaoDichEditDTO giaoDichEditDTO) throws SQLException {
        GiaoDichEditDTO giaoDichEditDTOs = giaoDichEditUC.editGD(giaoDichEditDTO);
        GiaoDichEditItem giaoDichEditItems = convertToPresent(giaoDichEditDTOs);
        giaoDichEditModel.listItem = giaoDichEditItems; // gửi thông đi
        giaoDichEditModel.notifySubscribers(); // thông báo đến subscribers
    }
}
