package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.converters.interfaces.EditDTOToGiaoDichDTOConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichDTOToBusinessConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToEditDTOConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

import java.sql.SQLException;

public class GiaoDichEditUC {
    private final GiaoDichDAOGateway giaoDichDAOGateway;
    private final EditDTOToGiaoDichDTOConverter editDTOToGiaoDichDTOConverter;
    private final GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter;
    private final GiaoDichToEditDTOConverter giaoDichToEditDTOConverter;

    public GiaoDichEditUC(GiaoDichDAOGateway giaoDichDAOGateway,
                          EditDTOToGiaoDichDTOConverter editDTOToGiaoDichDTOConverter,
                          GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter,
                          GiaoDichToEditDTOConverter giaoDichToEditDTOConverter) {
        this.giaoDichDAOGateway = giaoDichDAOGateway;
        this.editDTOToGiaoDichDTOConverter = editDTOToGiaoDichDTOConverter;
        this.giaoDichDTOToBusinessConverter = giaoDichDTOToBusinessConverter;
        this.giaoDichToEditDTOConverter = giaoDichToEditDTOConverter;
    }

    public GiaoDichEditDTO editGD(GiaoDichEditDTO giaoDichEditDTO) throws SQLException {
        GiaoDichDTO editDTO = giaoDichDAOGateway.editGiaoDich(editDTOToGiaoDichDTOConverter.convert(giaoDichEditDTO));
        GiaoDich giaoDich = giaoDichDTOToBusinessConverter.convert(editDTO);
        return giaoDichToEditDTOConverter.convert(giaoDich);
    }
}
