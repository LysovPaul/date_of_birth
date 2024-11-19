package org.example.tests;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class DateOfBirth {

    private AgeValidator ageValidator = new AgeValidator();

    //Тест сравнивает ожидаемый результат с фактическим
    @Test(dataProvider = "AgeDataProvider")
    public void testUserAgeValidation(LocalDate dateOfBirth, boolean expectedResult) {
        boolean actualResult = ageValidator.isUserEighteenYearsOld(dateOfBirth);
        assertThat(actualResult)
                .as("Validator validated the age correctly", dateOfBirth)
                .isEqualTo(expectedResult);
    }

    //Задаём граничные значения в виде параметров
    @DataProvider(name = "AgeDataProvider")
    public Object[][] provideAgeData() {
        return new Object[][]{
                {LocalDate.now().minusYears(18), true},
                {LocalDate.now().minusYears(18).plusDays(1), false},
                {LocalDate.now().minusYears(20), true},
                {LocalDate.now().minusYears(17), false},
                {LocalDate.now(), false},
        };
    }
}
