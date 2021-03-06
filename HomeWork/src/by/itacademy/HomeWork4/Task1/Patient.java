package by.itacademy.HomeWork4.Task1;

public class Patient {
    private String name;
    private String 	diagnostic;
    private int age;
    private boolean patientChartIsAvailable;

    public Patient(String name, String diagnostic, int age, boolean patientChartIsAvailable) {
        this.name = name;
        this.diagnostic = diagnostic;
        this.age = age;
        this.patientChartIsAvailable = patientChartIsAvailable;
    }

    public String getName() {
        return name;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public int getAge() {
        return age;
    }

    public boolean isPatientChartIsAvailable() {
        return patientChartIsAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPatientChartIsAvailable(boolean patientChartIsAvailable) {
        this.patientChartIsAvailable = patientChartIsAvailable;
    }
}

