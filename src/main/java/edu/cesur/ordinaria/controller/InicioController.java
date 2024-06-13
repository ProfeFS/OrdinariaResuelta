package edu.cesur.ordinaria.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController {
	@FXML
    private TextField txtDoctorName;

    @FXML
    private void viewPatients(ActionEvent event){
        String doctorName = txtDoctorName.getText();
        if (doctorName == null || doctorName.isEmpty()) {
            showAlert("Error", "Debe ingresar el nombre del Doctor.");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/cesur/ordinaria/vista/Patients.fxml"));
                Parent root = loader.load();

                // Get the controller of the next scene and pass the doctor's name
                PatientsController controller = loader.getController();
                controller.setDoctorName(doctorName);

    			// Obtiene el Stage actual a partir del evento del botón
                //Stage stage = (Stage) viewPatientsButton.getScene().getWindow();
    			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root)); // una forma, creando una nueva scena
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                showAlert("Error", "No se pudo cargar la vista de pacientes.");
            }
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


}