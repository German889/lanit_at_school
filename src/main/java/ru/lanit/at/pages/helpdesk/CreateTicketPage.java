package ru.lanit.at.pages.helpdesk;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница создания тикета")
public class CreateTicketPage extends WebPage {
    @Name("Выпадающий список очереди")
    private SelenideElement queueSelect = $(By.id("id_queue"));

    @Name("Поле заголовка")
    private SelenideElement titleInput = $(By.id("id_title"));

    @Name("Поле описания")
    private SelenideElement descInput = $(By.id("id_body"));

    @Name("Выпадающий список приоритета")
    private SelenideElement prioritySelect = $(By.id("id_priority"));

    @Name("Поле даты выполнения")
    private SelenideElement dueDateInput = $(By.id("id_due_date"));

    @Name("Поле email")
    private SelenideElement emailInput = $(By.id("id_submitter_email"));

    @Name("Кнопка отправки тикета")
    private SelenideElement submitBtn = $x("//form//button[@type='submit'] | //form//input[@type='submit']");
}