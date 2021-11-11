module com.mycompany.csc211.week11.paintappdemo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.csc211.week11.paintappdemo to javafx.fxml;
    exports com.mycompany.csc211.week11.paintappdemo;
}
