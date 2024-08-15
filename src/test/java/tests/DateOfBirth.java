package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class DateOfBirth {

    AgeValidator ageValidator = new AgeValidator();

    @Test(dataProvider = "AgeDataProvider")
    public void testUserAgeValidation(LocalDate dateOfBirth, boolean expectedResult) {
        boolean actualResult = ageValidator.isUserEighteenYearsOld(dateOfBirth);
        Assert.assertEquals(actualResult, expectedResult,
                "Ошибка!");
    }

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
