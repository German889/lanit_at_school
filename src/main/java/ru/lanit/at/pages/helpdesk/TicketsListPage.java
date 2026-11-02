package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница списка тикетов")
public class TicketsListPage extends WebPage {


    @Name("Выпадающий список сортировки")
    private SelenideElement sortSelect = $(By.id("id_sortx"));

    @Name("Чекбокс обратной сортировки")
    private SelenideElement sortReverseCheckbox = $(By.id("id_sortreverse"));

    @Name("Выпадающий список статусов")
    private SelenideElement statusSelect = $(By.id("id_statuses"));

    @Name("Поле ключевых слов")
    private SelenideElement keywordsInput = $(By.id("id_query"));

    @Name("Кнопка применить фильтры")
    private SelenideElement applyFiltersBtn = $x("//input[@value='Apply Filters']");

    @Name("Кнопка раскрытия сохранения запроса")
    private SelenideElement expandSaveQueryBtn = $x("//button[@data-target='#collapseTwo']");

    @Name("Поле названия запроса")
    private SelenideElement queryNameInput = $(By.id("id_title"));

    @Name("Чекбокс общего доступа")
    private SelenideElement sharedCheckbox = $(By.id("id_shared"));

    @Name("Кнопка сохранить запрос")
    private SelenideElement saveQueryBtn = $x("//form[@action='/save_query/']//input[@value='Save Query']");

    @Name("Выпадающий список сохраненных запросов")
    private SelenideElement savedQueriesSelect = $(By.id("id_query_selector"));

    @Name("Кнопка выполнить запрос")
    private SelenideElement runQueryBtn = $x("//form[@action='/tickets/']//input[@value='Run Query']");
}