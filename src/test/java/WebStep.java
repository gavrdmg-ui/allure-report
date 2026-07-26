import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStep {
    @Step("Открываем страницу с репозиториями")
    public void openProfileRepositories() {
        open("https://github.com/gavrdmg-ui?tab=repositories");
    }

    @Step("Ищем репозиторий {repo}")
    public void findRepository(String repo) {
        $(byText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем надличие Issue c именем {issue}")
    public void checkIssueWithName(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
