package tests;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator {
    public boolean isUserEighteenYearsOld(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        Period age = Period.between(dateOfBirth, today);
        return age.getYears() >= 18;
    }
}
