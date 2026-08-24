package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница поиска")
public class SearchPage extends WebPage {
    @Name("Поисковая строка")
    private SelenideElement searchInput = $x("//input[@name='query']");

    @Name("Кнопка сохранить поиск")
    private SelenideElement saveSearchBtn = $x("//button[@id='save-search']");
}