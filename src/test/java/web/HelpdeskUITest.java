package web;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурационные файлы")
    private void loadProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));
        MainPage mainPage = new MainPage();
        mainPage.mainMenu().clickOnNewTicketButton();
        ticket = buildNewTicket();
        CreateTicketPage createTicketPage = new CreateTicketPage();
        createTicketPage.createTicket(ticket);
        ViewPage viewPage = new ViewPage();
        viewPage.checkTicket(ticket);
        viewPage.saveId(ticket);

        viewPage.mainMenu().clickOnLogInButton();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(mainPage.mainMenu().loginedUser().trim(), "admin", "Имя пользователя не отображается на кнопке после логина");

        mainPage.mainMenu().searchTicket(ticket);

        TicketsPage ticketsPage = new TicketsPage();
        ticketsPage.openTicket(ticket);
        TicketPage ticketPage = new TicketPage();
        ticketPage.checkTicket(ticket);
    }

    private Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setQueue(1);

        ticket.setTitle("Автотест " + System.currentTimeMillis());
        ticket.setDescription("Описание для автоматического теста 12345");

        ticket.setPriority(3);
        ticket.setDue_date("2026-12-31");

        ticket.setSubmitter_email("test." + System.currentTimeMillis() + "@example.com");
        return ticket;
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}