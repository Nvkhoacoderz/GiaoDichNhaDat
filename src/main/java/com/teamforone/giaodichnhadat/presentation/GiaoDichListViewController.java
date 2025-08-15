package com.teamforone.giaodichnhadat.presentation;

import java.util.List;

import com.teamforone.giaodichnhadat.business.GiaoDichListViewUC;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ViewFindDTOListToViewItemListConverter;

import javafx.collections.FXCollections;

public class GiaoDichListViewController {
	private final GiaoDichEditModel viewModel;
	private final GiaoDichListViewUC listViewUC;
	private final ViewFindDTOListToViewItemListConverter viewFindDTOListToViewItemListConverter;
	
	public GiaoDichListViewController(GiaoDichEditModel viewModel, 
									  GiaoDichListViewUC listViewUC,
									  ViewFindDTOListToViewItemListConverter viewFindDTOListToViewItemListConverter) {
		this.viewModel = viewModel;
		this.listViewUC = listViewUC;
		this.viewFindDTOListToViewItemListConverter = viewFindDTOListToViewItemListConverter;
	}
	
	public void excute() {
		try {
			List<GiaoDichViewFindDTO> viewFindDTOs = listViewUC.excute();
			List<GDViewFindItem> gdViewFindItem = viewFindDTOListToViewItemListConverter.convert(viewFindDTOs);
			viewModel.listItems = FXCollections.observableArrayList(gdViewFindItem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
