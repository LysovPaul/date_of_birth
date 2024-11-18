package org.example.tests;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator {
    // Метод, который проверяет, исполнилось ли пользователю 18 лет
    public boolean isUserEighteenYearsOld(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        Period age = Period.between(dateOfBirth, today);
        return age.getYears() >= 18;
    }
}
