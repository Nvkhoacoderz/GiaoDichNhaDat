package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.FindGiaoDichUC;
import com.teamforone.giaodichnhadat.business.GiaoDichViewFindDTO;
import com.teamforone.giaodichnhadat.converters.interfaces.ViewFindDTOToViewItemConverter;

public class TimGiaoDichController {
    //chức năng tìm
	private final FindGiaoDichUC giaoDichUC;
	private GiaoDichEditModel gdModel;
	private final ViewFindDTOToViewItemConverter viewFindDTOToViewItemConverter;
	
	public TimGiaoDichController(FindGiaoDichUC giaoDichUC, 
								 GiaoDichEditModel gdModel,
								 ViewFindDTOToViewItemConverter viewFindDTOToViewItemConverter) {
		this.giaoDichUC = giaoDichUC;
		this.gdModel = gdModel;
		this.viewFindDTOToViewItemConverter = viewFindDTOToViewItemConverter;
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
			GDViewFindItem gdViewFindItem = viewFindDTOToViewItemConverter.convert(viewFindDTO);
			gdModel.viewItem = gdViewFindItem;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
