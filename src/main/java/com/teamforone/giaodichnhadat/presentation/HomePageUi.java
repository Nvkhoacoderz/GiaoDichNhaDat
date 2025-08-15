//package com.teamforone.giaodichnhadat.presentation;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class HomePageUi extends Application  implements Initializable {
//    @FXML
//    private TableView<GiaoDichViewDTO> tableView;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, String> colMa;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, String> colLoaiGiaoDich;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, String> colLoai;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, String> colDiaChi;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, LocalDate> colNgayGiaoDich;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, Double> colDonGia;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, Double> colDienTich;
//
//    @FXML
//    private TableColumn<GiaoDichViewDTO, Double> colThanhTien;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        colMa.setCellValueFactory(new PropertyValueFactory<>("maGiaoDich"));
//        colLoaiGiaoDich.setCellValueFactory(new PropertyValueFactory<>("loaiGiaoDich"));
//        colLoai.setCellValueFactory(new PropertyValueFactory<>("loai"));
//        colDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
//        colNgayGiaoDich.setCellValueFactory(new PropertyValueFactory<>("ngayGiaoDich"));
//        colDonGia.setCellValueFactory(new PropertyValueFactory<>("donGia"));
//        colDienTich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
//        colThanhTien.setCellValueFactory(new PropertyValueFactory<>("thanhTien"));
//
//        loadData(); // gọi hàm riêng
//    }
//
//    public void loadData() {
//        GiaoDichListViewUseCase usecase = new GiaoDichListViewUseCase(new MockDBGiaoDichListViewDAO());
//        List<GiaoDichViewDTO> danhSach = usecase.execute();
//        tableView.setItems(FXCollections.observableArrayList(danhSach));
//    }
//
//    @Override
//    public void start(javafx.stage.Stage primaryStage) {
//        try {
//            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("home-page.fxml"));
//            javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load(), 800, 600);
//            primaryStage.setScene(scene);
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
//        primaryStage.setTitle("Home Page");
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @FXML
//    private void handleThem(ActionEvent event) {
//        System.out.println("Đã bấm nút Thêm!");
//    }
//
//    @FXML
//    private void handleSua(ActionEvent event) {
//        System.out.println("Đã bấm nút Sửa!");
//    }
//
//    @FXML
//    private void handleXoa(ActionEvent event) {
//        System.out.println("Đã bấm nút Xóa!");
//    }
//    @FXML
//    private void handleDong(ActionEvent event) {
//        System.out.println("Đã bấm nút Thoát!");
//        javafx.application.Platform.exit(); // Đóng ứng dụng
//    }
//
//    @FXML
//    private void handleXuat(ActionEvent event) {
//        System.out.println("Đã Xuất Hoá Đơn!");
//        // Thêm logic xuất dữ liệu ở đây
//    }
//
//    @FXML
//    private void handleTrungBinh(ActionEvent event) {
//        System.out.println("Đã tính Trung Bình Giá!");
//        // Thêm logic tính trung bình giá ở đây
//    }
//}
package com.teamforone.giaodichnhadat.presentation;

import com.teamforone.giaodichnhadat.business.FindGiaoDichUC;
import com.teamforone.giaodichnhadat.business.GiaoDichListViewUC;
import com.teamforone.giaodichnhadat.converters.ConverterFactory;
import com.teamforone.giaodichnhadat.persistence.GiaoDichDTO;
import com.teamforone.giaodichnhadat.persistence.SQLServerGiaoDichEditDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomePageUi implements Subscriber{
    @FXML private TextField txtField;
    @FXML private Button btnTim;
    @FXML private TableView<GDViewFindItem> tableView;

    @FXML private TableColumn<GDViewFindItem, String> colMa;
    @FXML private TableColumn<GDViewFindItem, String> colLoaiGiaoDich;
    @FXML private TableColumn<GDViewFindItem, String> colLoai;
    @FXML private TableColumn<GDViewFindItem, String> colDiaChi;
    @FXML private TableColumn<GDViewFindItem, String> colNgayGiaoDich;
    @FXML private TableColumn<GDViewFindItem, String> colDonGia;
    @FXML private TableColumn<GDViewFindItem, String> colDienTich;
    @FXML private TableColumn<GDViewFindItem, String> colThanhTien;

    private TimGiaoDichController timGiaoDichController;
    private GiaoDichEditModel viewModel;
    private SQLServerGiaoDichEditDAO dao;

    // Danh sách đã load sẵn từ DB
    private ObservableList<GiaoDichDTO> danhSachGiaoDich = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        update();
    }
    @FXML
    public void update() {
        // Thiết lập cột hiển thị dữ liệu
        colMa.setCellValueFactory(new PropertyValueFactory<>("maGiaoDich"));
        colLoaiGiaoDich.setCellValueFactory(new PropertyValueFactory<>("loaiGD"));
        colLoai.setCellValueFactory(new PropertyValueFactory<>("loai")); // hoặc loaiNha
        colDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        colNgayGiaoDich.setCellValueFactory(new PropertyValueFactory<>("ngayGiaoDich"));
        colDonGia.setCellValueFactory(new PropertyValueFactory<>("donGia"));
        colDienTich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        colThanhTien.setCellValueFactory(new PropertyValueFactory<>("thanhTien"));

        // Load toàn bộ dữ liệu từ CSDL 1 lần duy nhất
        try {
            viewModel = new GiaoDichEditModel();
            dao = new SQLServerGiaoDichEditDAO();
            
            // Create UseCase with converter dependencies
            GiaoDichListViewUC listUC = new GiaoDichListViewUC(
                dao,
                ConverterFactory.getGiaoDichDTOToBusinessConverter(),
                ConverterFactory.getGiaoDichToViewFindDTOConverter()
            );
            GiaoDichListViewController listController = new GiaoDichListViewController(
                viewModel, 
                listUC,
                ConverterFactory.getViewFindDTOListToViewItemListConverter()
            );
            listController.excute(); // Load danh sách vào viewModel

            // Gán danh sách vào tableView
            tableView.setItems(viewModel.listItems);

            // Khởi tạo controller tìm kiếm
            FindGiaoDichUC findUC = new FindGiaoDichUC(
                dao,
                ConverterFactory.getGiaoDichDTOToBusinessConverter(),
                ConverterFactory.getGiaoDichToViewFindDTOConverter()
            );
            timGiaoDichController = new TimGiaoDichController(
                findUC, 
                viewModel,
                ConverterFactory.getViewFindDTOToViewItemConverter()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleTim() {
        String tuKhoa = txtField.getText().trim().toLowerCase();

        timGiaoDichController.excute(tuKhoa);

        GDViewFindItem item = timGiaoDichController.getGdModel().viewItem;
        if (tuKhoa.isEmpty() || item == null) {
            // Nếu không nhập gì thì hiển thị lại toàn bộ danh sách
            tableView.setItems(timGiaoDichController.getGdModel().listItems);
            return;
        }

        ObservableList<GDViewFindItem> ketQua = FXCollections.observableArrayList();
        ketQua.add(item);

        tableView.setItems(ketQua);
    }

    @FXML
    private void handleSua() {
        GDViewFindItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một giao dịch để sửa.");
            alert.showAndWait();
            return;
        }
        new GiaoDichEditUi().showDialog(selectedItem.getMaGiaoDich(), this::update);
    }

    @FXML
    private void handleDong(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}
