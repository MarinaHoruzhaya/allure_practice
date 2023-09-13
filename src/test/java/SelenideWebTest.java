import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWebTest extends TestBase {
    String REPOSITORY = "MarinaHoruzhaya/junit_practice";

    @Feature("Создание Issue")
    @Story("Создание Issue")
    @Owner("HoruzhayaMarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Simple test on Selenide")
    @Test
    public void buttonIssueExist() {

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("Welcome to issues!")).should(Condition.exist);
    }
}
