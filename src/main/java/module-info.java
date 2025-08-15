module com.teamforone.giaodichnhadat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;


    opens com.teamforone.giaodichnhadat.presentation to javafx.fxml;
    exports com.teamforone.giaodichnhadat.presentation;
}