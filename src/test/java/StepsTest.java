import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {
    String REPOSITORY = "MarinaHoruzhaya/junit_practice",
            NAME= "Welcome to issues!";

    @Feature("Создание Issue")
    @Story("Создание Issue")
    @Owner("HoruzhayaMarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @Test
    @DisplayName("Тест с использованием лямбда-выражений" )
    public void buttonIssueExistTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("ищем нужный репозиторий", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория", () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Открываем раздел Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие раздела Issue", () -> {
            $(withText(NAME)).should(Condition.exist);
        });
    }

    @Feature("Создание Issue")
    @Story("Создание Issue")
    @Owner("HoruzhayaMarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @Test
    @DisplayName("Тест с исполььзованием аннотации @step")
    public void issueAnnotatedTest(){
    WebSteps webSteps = new WebSteps();
    webSteps.openMainPage();
    webSteps.searchForRepository(REPOSITORY);
    webSteps.clickOnRepositoryLink(REPOSITORY);
    webSteps.openIssueTab();
    webSteps.shouldSeeTextInTabIssue(NAME);
    }

}
