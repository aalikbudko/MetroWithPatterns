module budko.metrowithpatterns {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    exports budko.metrowithpatterns.tests;
    opens budko.metrowithpatterns to javafx.fxml;
}