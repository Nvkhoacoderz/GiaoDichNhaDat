package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.business.GiaoDichEditUC;
import com.teamforone.giaodichnhadat.converters.interfaces.EditDTOToEditItemConverter;

import java.sql.SQLException;

public class GiaoDichEditController {
    private final GiaoDichEditModel giaoDichEditModel;
    private final GiaoDichEditUC giaoDichEditUC;
    private final EditDTOToEditItemConverter editDTOToEditItemConverter;

    public GiaoDichEditController(GiaoDichEditModel giaoDichEditModel, 
                                  GiaoDichEditUC giaoDichEditUC,
                                  EditDTOToEditItemConverter editDTOToEditItemConverter) {
        this.giaoDichEditModel = giaoDichEditModel;
        this.giaoDichEditUC = giaoDichEditUC;
        this.editDTOToEditItemConverter = editDTOToEditItemConverter;
    }

    public void editGD(GiaoDichEditDTO giaoDichEditDTO) throws SQLException {
        GiaoDichEditDTO giaoDichEditDTOs = giaoDichEditUC.editGD(giaoDichEditDTO);
        GiaoDichEditItem giaoDichEditItems = editDTOToEditItemConverter.convert(giaoDichEditDTOs);
        giaoDichEditModel.listItem = giaoDichEditItems; // gửi thông đi
        giaoDichEditModel.notifySubscribers(); // thông báo đến subscribers
    }
}
