package by.itacademy.Lesson17.e.domain.repository;

import by.itacademy.Lesson17.e.domain.entity.Money;

public interface MoneyRepository {
   Money get();
   void save(Money money);
}
