import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    private static final String issueName = "Issue for autotest";
    private static final String repositoryName = "allure-report";

    @Test
    public void stepIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открываем страницу с репозиториями", () -> {
            open("https://github.com/gavrdmg-ui?tab=repositories");
        });
        step("Ищем репозиторий " + repositoryName, () -> {
            $(byText(repositoryName)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем надличие Issue c именем " + issueName, () -> {
            $(withText(issueName)).should(Condition.exist);
        });

    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStep steps = new WebStep();

        steps.openProfileRepositories();
        steps.findRepository(repositoryName);
        steps.openIssueTab();
        steps.checkIssueWithName(issueName);

    }
}
