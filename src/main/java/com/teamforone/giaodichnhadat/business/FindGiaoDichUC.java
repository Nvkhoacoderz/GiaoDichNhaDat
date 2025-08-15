package com.teamforone.giaodichnhadat.business;

import java.sql.SQLException;
import java.text.ParseException;

import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichDTOToBusinessConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToViewFindDTOConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class FindGiaoDichUC {
	private final GiaoDichDAOGateway giaoDichGateway;
	private final GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter;
	private final GiaoDichToViewFindDTOConverter giaoDichToViewFindDTOConverter;

	public FindGiaoDichUC(GiaoDichDAOGateway giaoDichGateway,
						  GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter,
						  GiaoDichToViewFindDTOConverter giaoDichToViewFindDTOConverter) {
		this.giaoDichGateway = giaoDichGateway;
		this.giaoDichDTOToBusinessConverter = giaoDichDTOToBusinessConverter;
		this.giaoDichToViewFindDTOConverter = giaoDichToViewFindDTOConverter;
	}
	
	public GiaoDichViewFindDTO excute(String maGiaoDich) throws SQLException, ParseException{
		GiaoDich gd = null;
		GiaoDichDTO dto = null;
		
		try {
			dto = giaoDichGateway.timGiaoDich(maGiaoDich);
			gd = giaoDichDTOToBusinessConverter.convert(dto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return giaoDichToViewFindDTOConverter.convert(gd);
	}
}
