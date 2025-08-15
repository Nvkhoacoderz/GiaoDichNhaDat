package com.teamforone.giaodichnhadat.persistence.OpenAndEditForm;

import java.util.List;

public interface OpenEditFormGateway {
    List<ParentTypeDTO> getAll();
    List<ChildrenTypeDTO> getAll(String parentId);
}
