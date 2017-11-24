package by.itacademy.Lesson5.Task1;

public class Patient extends Human{
    private String chartNumber;
    private String doctorName;

    public String getChartNumber() {
        return chartNumber;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setChartNumber(String chartNumber) {
        this.chartNumber = chartNumber;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
