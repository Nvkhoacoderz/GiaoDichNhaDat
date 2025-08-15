package com.teamforone.giaodichnhadat.presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {

	@Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("timGiaoDich.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Quản lý Giao Dịch Nhà Đất");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // main() để khởi động JavaFX
    public static void main(String[] args) {
        launch(args);
    }

}
