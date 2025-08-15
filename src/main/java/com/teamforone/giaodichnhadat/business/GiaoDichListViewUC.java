package com.teamforone.giaodichnhadat.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichDTOToBusinessConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToViewFindDTOConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class GiaoDichListViewUC {
	private final GiaoDichDAOGateway giaoDichGateway;
	private final GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter;
	private final GiaoDichToViewFindDTOConverter giaoDichToViewFindDTOConverter;

	public GiaoDichListViewUC(GiaoDichDAOGateway giaoDichGateway,
							  GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter,
							  GiaoDichToViewFindDTOConverter giaoDichToViewFindDTOConverter){
		this.giaoDichGateway = giaoDichGateway;
		this.giaoDichDTOToBusinessConverter = giaoDichDTOToBusinessConverter;
		this.giaoDichToViewFindDTOConverter = giaoDichToViewFindDTOConverter;
	}
	
	public List<GiaoDichViewFindDTO> excute() throws SQLException, ParseException{
		List<GiaoDich> gds = null;
		List<GiaoDichDTO> dtos = null;
		
		try {
			dtos = giaoDichGateway.layTatCaGiaoDich();
			gds = giaoDichDTOToBusinessConverter.convertList(dtos);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return giaoDichToViewFindDTOConverter.convertList(gds);
	}
}
