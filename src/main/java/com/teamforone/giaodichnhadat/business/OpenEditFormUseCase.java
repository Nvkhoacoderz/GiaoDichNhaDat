package com.teamforone.giaodichnhadat.business;

import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichDTOToBusinessConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.GiaoDichToEditDTOConverter;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDAOGateway;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;

public class OpenEditFormUseCase {
    private final GiaoDichDAOGateway giaoDichDAOGateway;
    private final GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter;
    private final GiaoDichToEditDTOConverter giaoDichToEditDTOConverter;

    public OpenEditFormUseCase(GiaoDichDAOGateway giaoDichDAOGateway,
                               GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter,
                               GiaoDichToEditDTOConverter giaoDichToEditDTOConverter) {
        this.giaoDichDAOGateway = giaoDichDAOGateway;
        this.giaoDichDTOToBusinessConverter = giaoDichDTOToBusinessConverter;
        this.giaoDichToEditDTOConverter = giaoDichToEditDTOConverter;
    }

    public GiaoDichEditDTO openEditForm(String maGiaoDich) {
        GiaoDich st = null;
        GiaoDichDTO giaoDichDTO = null;
        try {
            giaoDichDTO = giaoDichDAOGateway.getGiaoDichByMa(maGiaoDich);
            st = giaoDichDTOToBusinessConverter.convert(giaoDichDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaoDichToEditDTOConverter.convert(st);
    }
}
