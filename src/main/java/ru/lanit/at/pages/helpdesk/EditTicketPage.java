package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница редактирования тикета")
public class EditTicketPage extends WebPage {
    @Name("Поле описания")
    private SelenideElement descInput = $(By.id("id_body"));

    // Твой локатор для прикрепления файла
    @Name("Поле прикрепления файла")
    private SelenideElement fileInput = $(By.id("id_attachment"));

    @Name("Кнопка сохранения изменений")
    private SelenideElement saveBtn = $x("//form//button[@type='submit'] | //form//input[@type='submit']");
}