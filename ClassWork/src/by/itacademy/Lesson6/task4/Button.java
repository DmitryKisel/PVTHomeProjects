package by.itacademy.Lesson6.task4;

public class Button {
    private Main main;
// записываем в Button ссылку на Main, что бы он мог вызвать методы у Main
    public void setMain(Main main) {
        this.main = main;
    }
 //симулируем нажатие на кнопку, это чисто тестовый метод
    public  void emulateClickOnButton(){
        if(main != null) main.onClick();
    }
}
