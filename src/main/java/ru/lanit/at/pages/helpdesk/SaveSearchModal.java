package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Модальное окно сохранения")
public class SaveSearchModal extends WebPage {
    @Name("Название поиска")
    private SelenideElement searchNameInput = $x("//input[@name='search-name']");

    @Name("Кнопка подтверждения сохранения")
    private SelenideElement confirmBtn = $x("//button[@id='confirm-save']");
}