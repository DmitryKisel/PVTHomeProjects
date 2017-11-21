package by.itacademy.HomeWork4.Task1;

public class Patient {
    String name;
    String 	diagnostic;
    int age;
    boolean patientChartIsAvailable;

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
}
