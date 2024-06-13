package edu.cesur.ordinaria.controller;

import java.util.Queue;

import edu.cesur.ordinaria.exception.PatientException;
import edu.cesur.ordinaria.model.Patient;
import edu.cesur.ordinaria.service.PatientService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientsController {
	@FXML
	private Label doctorNameLabel; // Muestra el nombre del doctor
	@FXML
	private TextField txtPatientName; // Campo de texto para el nombre del paciente
	@FXML
	private TextField txtPatientSeverity; // Campo de texto para la gravedad del paciente
	@FXML
	private TextField txtPatientStatus; // Campo de texto para el estado del paciente
	@FXML
	private TextField txtPatientObservation; // Campo de texto para la observación del paciente

	private Queue<Patient> patientQueue;
	private Patient currentPatient;
	private String doctorName;

	private PatientService patientService;

	public void initialize() {
		patientService = new PatientService();
		patientQueue = patientService.getPendingPatients();
		showNextPatient();
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
		doctorNameLabel.setText("Doctor: " + doctorName);
	}

	@FXML
	private void attendPatient() {
		// Botón "Atender paciente"
		if (currentPatient != null) {
			txtPatientObservation.setDisable(false);
			txtPatientStatus.setText("Attended");
		}
	}

	@FXML
	private void savePatient() {
		// Botón "Guardar"
		if (currentPatient != null) {
			String observation = txtPatientObservation.getText();
			if (observation == null || observation.isEmpty()) {
				showAlert("Error", "Debe ingresar una observación.");
				return;
			}
			currentPatient.setObservation(observation);
			currentPatient.setStatus("Attended");
			currentPatient.setDoctor(doctorName);
			patientService.updatePatient(currentPatient);
			showNextPatient();
		}
	}

	private void showNextPatient() {
		try {
			if (patientQueue.isEmpty()) {
				throw new PatientException("No existen más pacientes por atender.");
			} else {
				currentPatient = patientQueue.poll();
				if (currentPatient != null) {
					txtPatientName.setText(currentPatient.getName());
					txtPatientSeverity.setText(String.valueOf(currentPatient.getSeverity()));
					txtPatientStatus.setText(currentPatient.getStatus());
					txtPatientObservation.setText(currentPatient.getObservation());
					txtPatientObservation.setDisable(true);
				}
			}

		} catch (PatientException e) {
			showAlert("Información", e.getMessage());
		}

	}

	private void showAlert(String title, String content) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
