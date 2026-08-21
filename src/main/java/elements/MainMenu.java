package elements;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Главное меню (блок элементов) */
public class MainMenu {

    @FindBy(xpath = "//span[contains(text(),'New Ticket')]")
    private WebElement newTicketButton;

    @FindBy(id = "userDropdown")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@id='search_query']")
    private WebElement inputSearch;

    @FindBy(xpath = "//nav//button[@type='submit']")
    private WebElement goButton;

    public MainMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать кнопку создания новго тикета")
    public void clickOnNewTicketButton() {
        newTicketButton.click();
    }

    @Step("Нажать кнопку логина")
    public void clickOnLogInButton() {
        logInButton.click();
    }

    @Step("Найти тикет с помощью поиска")
    public void searchTicket(Ticket ticket) {
        setInputSearch(ticket.getTitle())
                .clickOnGoButton();
    }

    @Step("Ввести в поле поиска значение {text}")
    public MainMenu setInputSearch(String text) {
        inputSearch.sendKeys(text);
        return this;
    }

    @Step("Нажать кнопку поиска")
    public void clickOnGoButton() {
        goButton.click();
    }

    @Step("Получить логин пользователя")
    public String loginedUser() {
        return logInButton.getText();
    }
}
