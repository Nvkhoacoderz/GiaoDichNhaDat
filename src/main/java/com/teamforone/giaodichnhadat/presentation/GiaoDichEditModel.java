package com.teamforone.giaodichnhadat.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GiaoDichEditModel extends Publisher{
    public GiaoDichEditItem listItem;
    public GDViewFindItem viewItem;
    public ObservableList<GDViewFindItem> listItems = FXCollections.observableArrayList();
}
