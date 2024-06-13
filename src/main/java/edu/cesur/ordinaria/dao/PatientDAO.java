package edu.cesur.ordinaria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

import edu.cesur.ordinaria.model.Patient;

public interface PatientDAO {
	Queue<Patient> getPendingPatients() throws SQLException; // obtiene los pacientes pendiente de atención pero en una
																// cola de prioridad

	List<Patient> fetchPendingPatients() throws SQLException; // Obtiene todos los pacientes pendientes de atención, sin
																// ningún orden.

	void updatePatient(Patient patient) throws SQLException; // Actualiza la información de un paciente en la base de
																// datos.

	int getNumPatientsByDoctor(String doctorName) throws SQLException; // Método que obtiene el número de pacientes que
																		// ha atendido un doctor.

	List<Patient> getPatientsByDoctor(String doctorName) throws SQLException; // Obtiene todos los pacientes pendientes
																				// de atención, sin ningún orden.

}
