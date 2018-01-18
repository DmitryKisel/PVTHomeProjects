package by.itacademy.Lesson17.e.domain.useСase;

import by.itacademy.Lesson17.e.domain.entity.GetMoneyResult;
import by.itacademy.Lesson17.e.domain.entity.Money;
import by.itacademy.Lesson17.e.domain.repository.MoneyRepository;

public class GetMoneyUseCase implements UseCase {

    private MoneyRepository moneyRepository;

    public GetMoneyUseCase (MoneyRepository moneyRepository){
        this.moneyRepository = moneyRepository;
    }

    public void execute(Money money, GetMoneyListener resultListener){
        // Получаем текущее количество денег
        Money currentMoney = moneyRepository.get();
        // проверям достаточно ли денег
        if(currentMoney.getMoney() > money.getMoney()){
            Money newMoney = new Money();
            money.setMoney(currentMoney.getMoney()-money.getMoney());
          //сохраняет новое кол-во денег
            moneyRepository.save(newMoney);
           // возвращаем результат в presentation слой
            GetMoneyResult result = new GetMoneyResult();
            resultListener.onResult(result);
        }
    }

    public interface GetMoneyListener{
       void onResult(GetMoneyResult getMoneyResult);
       void onError();
    }
}
