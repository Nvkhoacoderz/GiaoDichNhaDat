package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

import java.sql.SQLException;

public class GiaoDichEditUC {
    private GiaoDichDAOGateway giaoDichDAOGateway;

    public GiaoDichEditUC(GiaoDichDAOGateway giaoDichDAOGateway) {
        this.giaoDichDAOGateway = giaoDichDAOGateway;
    }

    public GiaoDichEditDTO editGD(GiaoDichEditDTO giaoDichEditDTO) throws SQLException {
        GiaoDichDTO editDTO = giaoDichDAOGateway.editGiaoDich(convertToGiaoDichDTO(giaoDichEditDTO));
        GiaoDich giaoDich = convertToBusinessObjects(editDTO);
        return convertToViewDTO(giaoDich);
    }

    private GiaoDichDTO convertToGiaoDichDTO(GiaoDichEditDTO editDTO) {
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
