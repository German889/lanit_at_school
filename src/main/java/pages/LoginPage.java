package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница логина */
public class LoginPage extends HelpdeskBasePage {

    @FindBy(id = "username")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя.
     * Согласно требованию, данные авторизации получаем из конфигурационного файла user.properties.
     * Так как в HelpdeskUITest они загружены в System.properties, читаем их оттуда.
     */
    /**
     * Авторизация пользователя.
     * Если параметры не переданы, данные берутся из конфигурационного файла user.properties.
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    @Step("Авторизация пользователя")
    public LoginPage login(String user, String password) {
        // Если параметры пустые, читаем из конфигурационного файла
        String actualUser = (user != null && !user.isEmpty()) ? user : System.getProperty("user.name");
        String actualPassword = (password != null && !password.isEmpty()) ? password : System.getProperty("user.password");

        setUser(actualUser);
        setPassword(actualPassword);
        clickOnLoginButton();
        return this;
    }

    @Step("Ввести логин {user}")
    private void setUser(String user) {
        this.user.sendKeys(user);
    }

    @Step("Ввести пароль")
    private void setPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step("Нажать кнопку авторизации")
    private void clickOnLoginButton() {
        this.loginButton.click();
    }
}