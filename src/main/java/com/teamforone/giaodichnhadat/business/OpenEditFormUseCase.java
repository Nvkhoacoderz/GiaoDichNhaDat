package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class OpenEditFormUseCase {
    private GiaoDichDAOGateway giaoDichDAOGateway;

    public OpenEditFormUseCase(GiaoDichDAOGateway giaoDichDAOGateway) {
        this.giaoDichDAOGateway = giaoDichDAOGateway;
    }

    public GiaoDichEditDTO openEditForm(String maGiaoDich) {
        GiaoDich st = null;
        GiaoDichDTO giaoDichDTO = null;
        try {
            giaoDichDTO = giaoDichDAOGateway.getGiaoDichByMa(maGiaoDich);
            st = GiaoDichEditFactory.createGiaoDich(giaoDichDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertToViewDTO(st);
    }

    private GiaoDich convertToBusinessObjects(GiaoDichDTO dtos) {
        GiaoDich giaoDich = null;
        giaoDich = GiaoDichEditFactory.createGiaoDich(dtos);
        return giaoDich;
    }

    private GiaoDichEditDTO convertToViewDTO(GiaoDich st) {
        GiaoDichEditDTO dto = new GiaoDichEditDTO();
        dto.maGiaoDich = st.getMaGiaoDich();
        dto.ngayGiaoDich = st.getNgayGiaoDich();
        dto.donGia = st.getDonGia();
        dto.loaiGD = st.getLoai();
        dto.dienTich = st.getDienTich();
        if (st instanceof GiaoDichNha) {
            dto.loaiNha = ((GiaoDichNha) st).getLoaiNha();  // lấy loại chi tiết nhà
            dto.diaChi = ((GiaoDichNha) st).getDiaChi();
        } else if (st instanceof GiaoDichDat) {
            dto.loaiDat = ((GiaoDichDat) st).getLoaiDat();  // lấy loại chi tiết đất
        } else {
            dto.loaiNha = "";
            dto.loaiDat = "";
        }
        return dto;
    }
}
