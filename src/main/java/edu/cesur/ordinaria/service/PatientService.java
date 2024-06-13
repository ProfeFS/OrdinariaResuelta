package edu.cesur.ordinaria.service;

import java.sql.SQLException;
import java.util.Queue;

import edu.cesur.ordinaria.dao.PatientDAO;
import edu.cesur.ordinaria.dao.PatientDAOImpl;
import edu.cesur.ordinaria.model.Patient;

public class PatientService {
	private PatientDAO patientDAO;

	public PatientService() {
		this.patientDAO = new PatientDAOImpl();
	}

	public Queue<Patient> getPendingPatients() {
		try {
			return patientDAO.getPendingPatients();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public void updatePatient(Patient patient) {
		try {
			patientDAO.updatePatient(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
