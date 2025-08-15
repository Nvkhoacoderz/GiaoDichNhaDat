package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.FindGiaoDichUC;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;

import java.text.SimpleDateFormat;



public class TimGiaoDichController {
    //chức năng tìm
	private FindGiaoDichUC giaoDichUC;
	private GiaoDichEditModel gdModel;
	
	public TimGiaoDichController(FindGiaoDichUC giaoDichUC, GiaoDichEditModel gdModel) {
		super();
		this.giaoDichUC = giaoDichUC;
		this.gdModel = gdModel;
	}

	
	public GiaoDichEditModel getGdModel() {
		return gdModel;
	}


	public void setGdModel(GiaoDichEditModel gdModel) {
		this.gdModel = gdModel;
	}


	public void excute(String maGiaoDich) {
		try {
			GiaoDichViewFindDTO viewFindDTO = giaoDichUC.excute(maGiaoDich);
			GDViewFindItem gdViewFindItem = this.convertToViewModel(viewFindDTO);
			gdModel.viewItem = gdViewFindItem;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private GDViewFindItem convertToViewModel(GiaoDichViewFindDTO item) {
		GDViewFindItem viewItem = new GDViewFindItem();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		viewItem.setMaGiaoDich(item.maGiaoDich);
		viewItem.setDiaChi(item.diaChi);
		viewItem.setNgayGiaoDich(fmt.format(item.ngayGiaoDich));
		viewItem.setLoaiGD(item.loaiGD);
		viewItem.setDonGia(String.format("%.2f", item.donGia));
		viewItem.setLoai(item.loai);
		viewItem.setThanhTien(String.format("%.2f", item.thanhTien));
		viewItem.setDienTich(String.format("%.2f", item.dienTich));
		
		return viewItem;
	}
	
	
}
