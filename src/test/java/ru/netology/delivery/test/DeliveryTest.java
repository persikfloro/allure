package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.delivery.data.DataGenerator.generateDate;

class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = generateDate(daysToAddForSecondMeeting);
        $("[data-test-id=city] .input__control").setValue(validUser.getCity());
        $("[data-test-id=date] .input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id = date] .input__control").setValue(firstMeetingDate);
        $("[data-test-id = name] .input__control").setValue(validUser.getName());
        $("[data-test-id = phone] .input__control").setValue(validUser.getPhone());
        $("[data-test-id = agreement]").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на" + firstMeetingDate))
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .icon-button__text").click();
        $("[data-test-id=date] .input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue(secondMeetingDate);
        $(byText("Запланировать")).click();
        $("[data-test-id=replan-notification] .notification__content")
                .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(visible);
        $("[data-test-id=replan-notification] .button").click();
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(exactText("Встреча успешно запланирована на" + secondMeetingDate))
                .shouldBe(visible);
    }
}
