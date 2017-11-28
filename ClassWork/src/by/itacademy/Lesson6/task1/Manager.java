/*package by.itacademy.Lesson6.task1;

public class Manager {
    private Pacient[] pacientArray;

    public  void createTestData(){
        pacientArray = new Pacient[2];
        pacientArray[0] = new Pacient();

    }

    public Pacient[] searchByName(String name){
        Pacient search[]  = new Pacient[pacientArray.length];
        int i=0;
        for (Pacient pacient: pacientArray){
            if(pacient.getName().toLowerCase().equals(name.toLowerCase())){
                search[i] = pacient;
                i++;
            }
        }
        Pacient[] searchFinal = new Pacient[i];
        System.arraycopy(search, 0, searchFinal,0, i);
        return searchFinal;
    }
}
*/