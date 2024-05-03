module coe528.project.mavenproject6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens coe528.project.mavenproject6 to javafx.fxml;
    exports coe528.project.mavenproject6;
}
