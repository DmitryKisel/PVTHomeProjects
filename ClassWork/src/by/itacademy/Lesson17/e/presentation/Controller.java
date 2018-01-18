package by.itacademy.Lesson17.e.presentation;

import by.itacademy.Lesson17.e.domain.entity.GetMoneyResult;
import by.itacademy.Lesson17.e.domain.entity.Money;
import by.itacademy.Lesson17.e.domain.useСase.GetMoneyUseCase;

import java.util.ArrayList;

public class Controller {
// MVP - model view presenter
    // Model- View- ViewModel
  public View view;

  public Controller(View view){
      this.view = view;
  }

    public void getMoney(){
      GetMoneyUseCase getMoneyUseCase = new GetMoneyUseCase();
        Money money = new Money();
        money.setMoney(100);
        getMoneyUseCase.execute(money, new GetMoneyUseCase.GetMoneyListener() {
            @Override
            public void onResult(GetMoneyResult getMoneyResult) {
                view.showGetMoneyResult(true);
            }

            @Override
            public void onError() {
                view.showMessage("Деньги не снялись");
            }
        });

    }
}
