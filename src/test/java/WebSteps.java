import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step(value = "Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step(value = "Ищем нужный репозиторий")
    public void searchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step(value = "Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo){
        $(byLinkText(repo)).click();
    }

    @Step(value = "Открываем раздел Issue")
    public void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step(value = "Проверяем наличие раздела Issue c текстом {text}")
    public void shouldSeeTextInTabIssue(String text){
        $(withText(text)).should(Condition.exist);

    }


}
