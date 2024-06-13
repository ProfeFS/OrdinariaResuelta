package edu.cesur.ordinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.cesur.ordinaria.model.Patient;
import edu.cesur.ordinaria.utils.DatabaseConnection;

public class PatientDAOImpl implements PatientDAO {

	private Connection conn;

	public PatientDAOImpl() {
		this.conn = DatabaseConnection.getConnection();
	}

	@Override
	public Queue<Patient> getPendingPatients() {
		Queue<Patient> patients = new PriorityQueue<>();
		String sql = "SELECT * FROM Patients WHERE status = 'Pending'";
		try (PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Patient patient = new Patient(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getInt("severity"), resultSet.getString("status"),
						resultSet.getString("observation"), resultSet.getString("doctor"));
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public void updatePatient(Patient patient) {
		String sql = "UPDATE Patients SET status = ?, observation = ?, doctor = ? WHERE id = ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, patient.getStatus());
			statement.setString(2, patient.getObservation());
			statement.setString(3, patient.getDoctor());
			statement.setInt(4, patient.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Patient> fetchPendingPatients() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getNumPatientsByDoctor(String doctorName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Patient> getPatientsByDoctor(String doctorName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}