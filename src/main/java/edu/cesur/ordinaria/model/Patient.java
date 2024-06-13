package edu.cesur.ordinaria.model;

public class Patient implements Comparable<Patient>{
    private int id;
    private String name;
    private int severity;
    private String status;
    private String observation;
    private String doctor;

    public Patient(int id, String name, int severity, String status, String observation, String doctor) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.status = status;
        this.observation = observation;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }

    public String getObservation() {
        return observation;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Prioridad por gravedad, de mayor a menor
    }

}
