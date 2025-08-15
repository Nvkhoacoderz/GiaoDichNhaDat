package com.teamforone.giaodichnhadat.presentation.OpenAndEditForm;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;
import com.teamforone.giaodichnhadat.presentation.GiaoDichEditItem;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.ChildrenTypeItem;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.OpenAndEditFormController;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.OpenEditFormModel;
import com.teamforone.giaodichnhadat.presentation.OpenAndEditForm.ParentTypeItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class OpenAndEditFormView {

    private OpenEditFormModel model;
    private OpenAndEditFormController controller;

    public OpenAndEditFormView(OpenEditFormModel model, OpenAndEditFormController controller) {
        this.model = model;
        this.controller = controller;
    }

    public GiaoDichEditDTO showDialog(GiaoDichEditItem editItem) {
        final GiaoDichEditDTO[] result = {null};
        Stage stage = new Stage();
        stage.setTitle("Sửa giao dịch");
        stage.initModality(Modality.APPLICATION_MODAL);

        double fieldWidth = 420;
        Font labelFont = Font.font("Segoe UI", FontWeight.BOLD, 16);

        // Map hiển thị <-> giá trị logic
        Map<String, String> displayToValue = new LinkedHashMap<>();
        displayToValue.put("Nhà", "nha");
        displayToValue.put("Đất", "dat");
        Map<String, String> valueToDisplay = new LinkedHashMap<>();
        valueToDisplay.put("nha", "Nhà");
        valueToDisplay.put("dat", "Đất");

        // Trường nhập liệu chung
        Label lblMaGD = new Label("Mã giao dịch:"); lblMaGD.setFont(labelFont);
        TextField txtMaGiaoDich = new TextField(editItem.getMaGiaoDich());
        txtMaGiaoDich.setEditable(false); txtMaGiaoDich.setPrefWidth(fieldWidth);

        Label lblNgayGD = new Label("Ngày giao dịch:"); lblNgayGD.setFont(labelFont);
        DatePicker dateNgayGiaoDich = new DatePicker();
        dateNgayGiaoDich.setPrefWidth(fieldWidth);
        try { dateNgayGiaoDich.setValue(LocalDate.parse(editItem.getNgayGiaoDich())); } catch (Exception e) { }

        Label lblDonGia = new Label("Đơn giá:"); lblDonGia.setFont(labelFont);
        TextField txtDonGia = new TextField(editItem.getDonGia()); txtDonGia.setPrefWidth(fieldWidth);

        Label lblLoaiGD = new Label("Loại giao dịch:"); lblLoaiGD.setFont(labelFont);
        ComboBox<String> comboLoaiGiaoDich = new ComboBox<>();
        comboLoaiGiaoDich.getItems().addAll(displayToValue.keySet());
        comboLoaiGiaoDich.setValue(valueToDisplay.getOrDefault(editItem.getLoai(), "Nhà"));
        comboLoaiGiaoDich.setPrefWidth(fieldWidth);

        Label lblDienTich = new Label("Diện tích:"); lblDienTich.setFont(labelFont);
        TextField txtDienTich = new TextField(editItem.getDienTich()); txtDienTich.setPrefWidth(fieldWidth);

        // Đây là combo dùng cho loại con (ChildrenTypeItem) cho cả nhà và đất
        Label lblLoaiCon = new Label("Loại nhà:"); lblLoaiCon.setFont(labelFont);
        ComboBox<ChildrenTypeItem> comboLoaiCon = new ComboBox<>();
        comboLoaiCon.setPrefWidth(fieldWidth);

        comboLoaiCon.setCellFactory(lv -> new ListCell<ChildrenTypeItem>() {
            @Override
            protected void updateItem(ChildrenTypeItem item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.name);
            }
        });
        comboLoaiCon.setButtonCell(new ListCell<ChildrenTypeItem>() {
            @Override
            protected void updateItem(ChildrenTypeItem item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.name);
            }
        });

        Label lblDiaChi = new Label("Địa chỉ:"); lblDiaChi.setFont(labelFont);
        TextField txtDiaChi = new TextField(editItem.getDiaChi()); txtDiaChi.setPrefWidth(fieldWidth);

        // --- GridPane layout ---
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(28, 38, 12, 38));
        grid.setHgap(20); grid.setVgap(22);

        int row = 0;
        grid.add(lblMaGD, 0, row); grid.add(txtMaGiaoDich, 1, row++);
        grid.add(lblNgayGD, 0, row); grid.add(dateNgayGiaoDich, 1, row++);
        grid.add(lblDonGia, 0, row); grid.add(txtDonGia, 1, row++);
        grid.add(lblLoaiGD, 0, row); grid.add(comboLoaiGiaoDich, 1, row++);

        grid.add(lblLoaiCon, 0, row); grid.add(comboLoaiCon, 1, row++);
        grid.add(lblDiaChi, 0, row); grid.add(txtDiaChi, 1, row++);
        grid.add(lblDienTich, 0, row); grid.add(txtDienTich, 1, row++);

        // --- Load loại cha khi mở form ---
        controller.execute();

        // --- Khi chọn loại giao dịch (Nhà/Đất), gọi controller để lấy loại con ---
        comboLoaiGiaoDich.setOnAction(ev -> {
            // Tìm id loại cha theo tên hiển thị
            String selectedDisplay = comboLoaiGiaoDich.getValue(); // "Nhà"/"Đất"
            String parentId = null;
            if (model.parentTypeItems != null) {
                for (ParentTypeItem item : model.parentTypeItems) {
                    if (item.name.equals(selectedDisplay)) {
                        parentId = item.id;
                        break;
                    }
                }
            }
            if (parentId != null) {
                controller.executes(parentId); // lấy loại con theo id cha
            }

            // Ẩn/hiện label địa chỉ (chỉ cho Nhà)
            boolean isNha = "Nhà".equals(selectedDisplay);
            lblLoaiCon.setText(isNha ? "Loại nhà:" : "Loại đất:");
            txtDiaChi.setVisible(isNha);
            txtDiaChi.setManaged(isNha);
            lblDiaChi.setVisible(isNha);
            lblDiaChi.setManaged(isNha);
        });

        // --- Lắng nghe cập nhật loại con khi model.childrenTypeItems thay đổi ---
        model.registerSubscriber(() -> {
            comboLoaiCon.getItems().clear();
            if (model.childrenTypeItems != null) {
                comboLoaiCon.getItems().addAll(model.childrenTypeItems);

                // Đặt giá trị mặc định cho ComboBox loại con
                ChildrenTypeItem selectedItem = null;
                String loaiGDValue = displayToValue.get(comboLoaiGiaoDich.getValue());
                if ("dat".equals(loaiGDValue) && editItem.getLoaiDat() != null) {
                    for (ChildrenTypeItem item : model.childrenTypeItems) {
                        if (item.name.equals(editItem.getLoaiDat())) {
                            selectedItem = item;
                            break;
                        }
                    }
                } else if ("nha".equals(loaiGDValue) && editItem.getLoaiNha() != null) {
                    for (ChildrenTypeItem item : model.childrenTypeItems) {
                        if (
                                ("cao_cap".equals(editItem.getLoaiNha()) && "Cao cấp".equals(item.name)) ||
                                        ("thuong".equals(editItem.getLoaiNha()) && "Thường".equals(item.name))
                        ) {
                            selectedItem = item;
                            break;
                        }
                    }
                }
                if (selectedItem != null) {
                    comboLoaiCon.setValue(selectedItem);
                }
            }
        });

        // --- Nút ---
        Button btnLuu = new Button("Lưu");
        Button btnThoat = new Button("Thoát");
        btnLuu.setPrefWidth(120);
        btnThoat.setPrefWidth(120);
        HBox buttonBox = new HBox(32, btnLuu, btnThoat);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(34, 0, 28, 0));

        VBox root = new VBox(grid, buttonBox);
        root.setStyle("-fx-background-color: #f7f7fa;");

        Scene scene = new Scene(root, 820, 470);
        stage.setScene(scene);

        // --- Xử lý lưu ---
        btnLuu.setOnAction(e -> {
            try {
                String displayLoaiGD = comboLoaiGiaoDich.getValue();
                String loaiGD = displayToValue.get(displayLoaiGD);

                GiaoDichEditDTO dto = new GiaoDichEditDTO();
                dto.maGiaoDich = txtMaGiaoDich.getText();
                dto.ngayGiaoDich = dateNgayGiaoDich.getValue();
                dto.donGia = Double.parseDouble(txtDonGia.getText());
                dto.loaiGD = loaiGD;
                dto.dienTich = Double.parseDouble(txtDienTich.getText());

                ChildrenTypeItem selected = comboLoaiCon.getValue();
                if ("dat".equals(loaiGD)) {
                    // Đúng: lấy selected.name ("A", "B", "C") cho LoaiDat
                    dto.loaiDat = selected != null ? selected.name : null;
                    dto.loaiNha = null;
                    dto.diaChi = null;
                } else if ("nha".equals(loaiGD)) {
                    // Mapping cho loại nhà như đã hướng dẫn trước
                    if (selected != null) {
                        if ("Cao cấp".equals(selected.name)) dto.loaiNha = "cao_cap";
                        else if ("Thường".equals(selected.name)) dto.loaiNha = "thuong";
                        else dto.loaiNha = selected.name;
                    } else {
                        dto.loaiNha = null;
                    }
                    dto.diaChi = txtDiaChi.getText();
                    dto.loaiDat = null;
                }
                result[0] = dto;
                stage.close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Lỗi nhập liệu: " + ex.getMessage()).showAndWait();
            }
        });
        btnThoat.setOnAction(e -> {
            result[0] = null;
            stage.close();
        });

        // --- Khi mở form thì load luôn loại con cho loại mặc định ---
        comboLoaiGiaoDich.fireEvent(new javafx.event.ActionEvent());

        stage.showAndWait();
        return result[0];
    }
}