package by.itacademy.Lesson5.Task1;

public class OOP1 {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setName("John Arnold");
        patient.setDoctorName("Lee Wong");
        System.out.println(patient.getName() + " " + patient.getDoctorName());
        Human human = new Patient();

    }
}
