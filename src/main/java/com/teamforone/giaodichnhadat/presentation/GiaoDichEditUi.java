package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.*;
import com.teamforone.giaodichnhadat.business.OpenAndEditForm.OpenAndEditFormUseCase;
import com.teamforone.giaodichnhadat.persistence.OpenAndEditForm.SQLServerOpenEditForm;
import com.teamforone.giaodichnhadat.persistence.SQLServerGiaoDichEditDAO;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.OpenAndEditFormController;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.OpenAndEditFormView;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.OpenEditFormModel;
import javafx.scene.control.Alert;

public class GiaoDichEditUi implements Subscriber {
    private GiaoDichEditModel viewModel;

    public void showDialog(String maGiaoDich, Runnable onSaveCallback) {
        try {
            viewModel = new GiaoDichEditModel();
            SQLServerOpenEditForm openEditFormDAO = new SQLServerOpenEditForm();
            SQLServerGiaoDichEditDAO giaoDichDAO = new SQLServerGiaoDichEditDAO();
            OpenEditFormUseCase openEditFormUseCase = new OpenEditFormUseCase(giaoDichDAO);
            OpenEditFormController openForm = new OpenEditFormController(viewModel, openEditFormUseCase);
            OpenEditFormModel model = new OpenEditFormModel();
            OpenAndEditFormUseCase openAndEditFormUseCase = new OpenAndEditFormUseCase(openEditFormDAO);
            OpenAndEditFormController openAndEditFormController = new OpenAndEditFormController(openAndEditFormUseCase,model);
            openForm.openEditForm(maGiaoDich);

            GiaoDichEditItem item = viewModel.listItem;
            if (item != null) {
                // Hiển thị form nhập liệu
                OpenAndEditFormView formView = new OpenAndEditFormView(model, openAndEditFormController);
                GiaoDichEditDTO edited = formView.showDialog(item); // Form trả về DTO đã sửa hoặc null nếu cancel
                if (edited != null) {
                    // Lưu dữ liệu vừa sửa
                    GiaoDichEditController editController = new GiaoDichEditController(viewModel, new GiaoDichEditUC(giaoDichDAO));
                    editController.editGD(edited);
                    new Alert(Alert.AlertType.INFORMATION, "Lưu thành công!").showAndWait();
                    if (onSaveCallback != null) onSaveCallback.run(); // Reload lại danh sách nếu cần
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Không tìm thấy giao dịch!").showAndWait();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Không thể mở giao diện sửa giao dịch!\n" + ex.getMessage()).showAndWait();
        }
    }

    @Override
    public void update() {}
}