
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestApplicationForm {

    @Test
    void login() {
        open("http://localhost:9999");
        SelenideElement form = $("[id = root]");
        form.$("[data-test-id=name] input").setValue("Бубка Гоп");
        form.$("[data-test-id=phone] input").setValue("+78005553535");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]")
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется" +
                " с вами в ближайшее время."));
    }

}
