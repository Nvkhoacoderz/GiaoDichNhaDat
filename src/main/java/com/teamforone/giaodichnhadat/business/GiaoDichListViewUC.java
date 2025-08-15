package com.teamforone.giaodichnhadat.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class GiaoDichListViewUC {
	private GiaoDichDAOGateway giaoDichGateway;

	public GiaoDichListViewUC(GiaoDichDAOGateway giaoDichGateway){
		super();
		this.giaoDichGateway = giaoDichGateway;
	}
	
	public List<GiaoDichViewFindDTO> excute() throws SQLException, ParseException{
		List<GiaoDich> gds = null;
		List<GiaoDichDTO> dtos = null;
		
		try {
			dtos = giaoDichGateway.layTatCaGiaoDich();
			
			gds = this.convertToBusinessObject(dtos);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return this.convertToViewModel(gds);
	}
	
	private List<GiaoDich> convertToBusinessObject(List<GiaoDichDTO> dtos) {
		List<GiaoDich> gds = new ArrayList<GiaoDich>();
		
		for(GiaoDichDTO dto : dtos) {
			GiaoDich gd = GiaoDichEditFactory.createGiaoDich(dto);
			gds.add(gd);
		}
		
		return gds;
	}
	
	private List<GiaoDichViewFindDTO> convertToViewModel(List<GiaoDich> gds) {
		List<GiaoDichViewFindDTO> dtoViews = new ArrayList<GiaoDichViewFindDTO>();
		for(GiaoDich gd : gds) {
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

			dtoViews.add(dtoView);
		}
		
		return dtoViews;
	}
}
