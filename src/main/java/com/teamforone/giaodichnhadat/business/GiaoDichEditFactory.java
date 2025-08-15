package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class GiaoDichEditFactory {
    public static GiaoDich createGiaoDich(GiaoDichDTO giaoDichDTO) {
         if("nha".equalsIgnoreCase(giaoDichDTO.loaiGiaoDich)) {
            return new GiaoDichNha(giaoDichDTO.maGiaoDich, giaoDichDTO.ngayGiaoDich,
                    giaoDichDTO.donGia, giaoDichDTO.dienTich, giaoDichDTO.diaChi,
                    giaoDichDTO.loaiNha);
         } else if("dat".equalsIgnoreCase(giaoDichDTO.loaiGiaoDich)) {
            return new GiaoDichDat(giaoDichDTO.maGiaoDich, giaoDichDTO.ngayGiaoDich,
                    giaoDichDTO.donGia, giaoDichDTO.dienTich,
                    giaoDichDTO.loaiDat);
         }
         return null;
    }
}
