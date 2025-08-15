package com.teamforone.giaodichnhadat.business.OpenAndEditForm;

import com.teamforone.giaodichnhadat.converters.interfaces.ChildrenTypeDTOConverter;
import com.teamforone.giaodichnhadat.converters.interfaces.ParentTypeDTOConverter;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ChildrenTypeDTO;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.OpenEditFormGateway;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.ParentTypeDTO;

import java.util.List;

public class OpenAndEditFormUseCase {
    private final OpenEditFormGateway openEditFormGateway;
    private final ParentTypeDTOConverter parentTypeDTOConverter;
    private final ChildrenTypeDTOConverter childrenTypeDTOConverter;

    public OpenAndEditFormUseCase(OpenEditFormGateway openEditFormGateway,
                                  ParentTypeDTOConverter parentTypeDTOConverter,
                                  ChildrenTypeDTOConverter childrenTypeDTOConverter) {
        this.openEditFormGateway = openEditFormGateway;
        this.parentTypeDTOConverter = parentTypeDTOConverter;
        this.childrenTypeDTOConverter = childrenTypeDTOConverter;
    }

    public List<ResParentTypeDTO> execute() {
        List<ParentTypeDTO> listDTO = openEditFormGateway.getAll();
        return parentTypeDTOConverter.convertList(listDTO);
    }

    public List<ResChildrenTypeDTO> executes(String parentId) {
        List<ChildrenTypeDTO> listDTO = openEditFormGateway.getAll(parentId);
        return childrenTypeDTOConverter.convertList(listDTO);
    }
}
