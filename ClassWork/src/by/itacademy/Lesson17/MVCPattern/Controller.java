package by.itacademy.Lesson17.MVCPattern;

import java.util.ArrayList;

public class Controller {
// MVP - model view presenter
    // Model- View- ViewModel
  private View view;
  private ArrayList<Model> data;

  public Controller(View view){
      this.view = view;
  }

   public String getDataSortedByName(){
       return data.get(5).getName();
   }

    public String getHello(){
        return "Hello";
    }

    public int getNumber(){
        view.showMessage("###");
        return 5;
    }
}
