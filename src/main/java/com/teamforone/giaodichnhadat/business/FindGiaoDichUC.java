package com.teamforone.giaodichnhadat.business;

import java.sql.SQLException;
import java.text.ParseException;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class FindGiaoDichUC {
	private GiaoDichDAOGateway giaoDichGateway;

	public FindGiaoDichUC(GiaoDichDAOGateway giaoDichGateway) {
		super();
		this.giaoDichGateway = giaoDichGateway;
	}
	
	public GiaoDichViewFindDTO excute(String maGiaoDich) throws SQLException, ParseException{
		GiaoDich gd = null;
		GiaoDichDTO dto = null;
		
		try {
			dto = giaoDichGateway.timGiaoDich(maGiaoDich);
			
			gd = this.convertToBusinessObject(dto);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return this.convertToViewModel(gd);
	}
	
	private GiaoDich convertToBusinessObject(GiaoDichDTO dto) {
		GiaoDich gd = null;
		
		gd = GiaoDichFindFactory.createGiaoDich(dto);
		
		return gd;
	}
	
	private GiaoDichViewFindDTO convertToViewModel(GiaoDich gd) {
		GiaoDichViewFindDTO dtoView = new GiaoDichViewFindDTO();
		dtoView.maGiaoDich = gd.getMaGiaoDich();
		dtoView.ngayGiaoDich = gd.getNgayGiaoDich();
		dtoView.donGia = gd.getDonGia();
		dtoView.dienTich = gd.getDienTich();
		dtoView.loai = gd.getLoai();
		dtoView.thanhTien = gd.thanhTien();
		if (gd instanceof GiaoDichNha) {
			dtoView.loaiGD = "nha";
			dtoView.loai = ((GiaoDichNha) gd).getLoaiNha();  // lấy loại chi tiết nhà
			dtoView.diaChi = ((GiaoDichNha) gd).getDiaChi();
		} else if (gd instanceof GiaoDichDat) {
			dtoView.loaiGD = "dat";
			dtoView.loai = ((GiaoDichDat) gd).getLoaiDat();  // lấy loại chi tiết đất
		} else {
			dtoView.loaiGD = "";
			dtoView.loai = "";
			dtoView.diaChi = "";
		}


		return dtoView;
	}
}
