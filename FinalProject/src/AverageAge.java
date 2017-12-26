import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AverageAge {
    private static  Date currentDate = new Date();
    private static int currentYear = currentDate.getYear()+ 1900;
    private static  int currentMonth = currentDate.getMonth()+1;

    /**
     * This method calculates the average age of employees and calls method printAverageAge
     * @param list
     */
    public  void averageAge(List<Employee> list) {
        int count = 0;
        int monthSum = 0;

        for (Employee person : list) {
            Date date = person.getDateOfBirth();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            int month = gc.get(GregorianCalendar.MONTH)+ 1;
            int year = gc.get(GregorianCalendar.YEAR);
            int ageYears = currentYear - year;
            int ageMonth = currentMonth - month;
            if (ageMonth < 0) {
                ageYears = ageYears - 1;
                ageMonth = 12 + ageMonth;
            }

            monthSum = monthSum + ageYears*12+ ageMonth;
            count++;
        }

        int averageYears = (monthSum/12)/count;
        int averageMonth = Math.round((monthSum - averageYears*12*count)/count);
        printAverageAge(averageYears, averageMonth);

    }

    /**
     * This method prints the average age of employees in special format
     * @param averageMonth
     */
    public  void printAverageAge(int averageYears, int averageMonth) {
        StringBuilder sb = new StringBuilder();
        sb.append("Средний возраст сотрудников составляет ");
        sb.append(averageYears);

        switch (averageYears%10){
            case 1: { sb.append(" год ");}
            case 2: { sb.append(" года ");}
            case 3: { sb.append(" года ");}
            case 4: { sb.append(" года ");}
            default:  { sb.append(" лет ");}

        }

        if (averageMonth == 0) {
            System.out.println(sb.toString().trim());
        }
        else {
            sb.append("и ");
            sb.append(averageMonth);
            switch (averageMonth){
                case 1:{
                    sb.append(" месяц");
                    break;
                }

                case 2: {
                    sb.append(" месяца");
                    break;
                }
                case 3: {
                    sb.append(" месяца");
                    break;
                }
                case 4: {
                    sb.append(" месяца");
                    break;
                }
                default: {
                    sb.append(" месяцев");
                    break;
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}
