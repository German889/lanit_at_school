package ru.lanit.at.pages.helpdesk;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница авторизации")
public class LoginPage extends WebPage {
    @Name("Поле логина")
    private SelenideElement usernameInput = $(By.id("username"));

    @Name("Поле пароля")
    private SelenideElement passwordInput = $(By.id("password"));

    @Name("Кнопка авторизации")
    private SelenideElement submitBtn = $x("//form//button[@type='submit'] | //form//input[@type='submit']");
}