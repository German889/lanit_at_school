package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница просмотра тикета")
public class ViewTicketPage extends WebPage {
    @Name("Заголовок тикета")
    private SelenideElement ticketTitle = $x("//table/caption | //h2[contains(., 'Ticket')] | //h3[contains(., 'Ticket')]");

    // В Django Helpdesk кнопка Edit обычно содержит текст "Edit" или ссылку на /edit/
    @Name("Кнопка редактирования")
    private SelenideElement editBtn = $x("//a[contains(., 'Edit') or contains(@href, '/edit/')]");
}