package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").clear();
        $("[data-test-id=date] input").setValue("24.08.2023");
        $("[data-test-id=name] input").setValue("Иванов Иван Иванович");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $(byText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
