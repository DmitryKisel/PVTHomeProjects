package by.itacademy.Lesson6.task4_1;

public class Button {
    private ButtonClick buttonClick;
// записываем в Button ссылку на Main, что бы он мог вызвать методы у Main
    public void setButtonClick(ButtonClick buttonClick) {
        this.buttonClick = buttonClick;
    }
 //симулируем нажатие на кнопку, это чисто тестовый метод
    public  void emulateClickOnButton(){
        if(buttonClick != null) buttonClick.onClick();
    }
}
