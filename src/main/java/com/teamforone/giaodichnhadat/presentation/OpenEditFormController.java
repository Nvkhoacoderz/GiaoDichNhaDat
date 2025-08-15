package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.business.OpenEditFormUseCase;
import com.teamforone.giaodichnhadat.converters.interfaces.EditDTOToEditItemConverter;


public class OpenEditFormController {
    private final GiaoDichEditModel model;
    private final OpenEditFormUseCase useCase;
    private final EditDTOToEditItemConverter editDTOToEditItemConverter;

    public OpenEditFormController(GiaoDichEditModel model, 
                                  OpenEditFormUseCase useCase,
                                  EditDTOToEditItemConverter editDTOToEditItemConverter) {
        this.model = model;
        this.useCase = useCase;
        this.editDTOToEditItemConverter = editDTOToEditItemConverter;
    }

    public void openEditForm(String maGiaoDich) {
        try {
            GiaoDichEditDTO items = useCase.openEditForm(maGiaoDich);
            GiaoDichEditItem viewItems = editDTOToEditItemConverter.convert(items);
            model.listItem = viewItems;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
