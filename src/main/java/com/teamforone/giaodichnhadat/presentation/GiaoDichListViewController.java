package com.teamforone.giaodichnhadat.presentation;

import java.util.ArrayList;
import java.util.List;

import com.teamforone.giaodichnhadat.business.GiaoDichListViewUC;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;

import javafx.collections.FXCollections;

public class GiaoDichListViewController {
	private GiaoDichEditModel viewModel;
	private GiaoDichListViewUC listViewUC;
	public GiaoDichListViewController(GiaoDichEditModel viewModel, GiaoDichListViewUC listViewUC) {
		super();
		this.viewModel = viewModel;
		this.listViewUC = listViewUC;
	}
	
		public void excute() {
			try {
				List<GiaoDichViewFindDTO> viewFindDTOs = listViewUC.excute();
				List<GDViewFindItem> gdViewFindItem = this.convertToViewModel(viewFindDTOs);
				viewModel.listItems = FXCollections.observableArrayList(gdViewFindItem);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}


		private List<GDViewFindItem> convertToViewModel(List<GiaoDichViewFindDTO> items) {
			List<GDViewFindItem> viewItems = new ArrayList<GDViewFindItem>();
			for(GiaoDichViewFindDTO item : items) {
				GDViewFindItem viewItem = new GDViewFindItem();
				viewItem.setMaGiaoDich(item.maGiaoDich);
				viewItem.setDiaChi(item.diaChi);
				viewItem.setNgayGiaoDich((item.ngayGiaoDich).toString());
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
