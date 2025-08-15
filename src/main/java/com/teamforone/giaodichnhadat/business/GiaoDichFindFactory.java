package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class GiaoDichFindFactory {
    public static GiaoDich createGiaoDich(GiaoDichDTO dto) {
        if("nha".equalsIgnoreCase(dto.loaiGiaoDich)) {
            return new GiaoDichNha(
                    dto.maGiaoDich,
                    dto.ngayGiaoDich,
                    dto.donGia,
                    dto.dienTich,
                    dto.diaChi,
                    dto.loaiNha);
        }else if("dat".equalsIgnoreCase(dto.loaiGiaoDich)) {
            return new GiaoDichDat(
                    dto.maGiaoDich,
                    dto.ngayGiaoDich,
                    dto.donGia,
                    dto.dienTich,
                    dto.loaiDat);
        }

        return null;
    }

}
