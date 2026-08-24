package ru.lanit.at.pages.helpdesk;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Главная страница Helpdesk")
public class HelpdeskMainPage extends WebPage {
    @Name("Кнопка создания тикета")
    private SelenideElement newTicketBtn = $x("//span[contains(text(),'New Ticket')]");

    @Name("Кнопка входа")
    private SelenideElement loginBtn = $(By.id("userDropdown"));

    @Name("Поле поиска")
    private SelenideElement searchInput = $(By.id("search_query"));

    @Name("Кнопка поиска")
    private SelenideElement searchGoBtn = $x("//nav//button[@type='submit']");
}