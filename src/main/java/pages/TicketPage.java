package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TicketPage extends HelpdeskBasePage {

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(xpath = "//th[./h3]")
    private WebElement ticketHeader;

    @FindBy(xpath = "//th[contains(., 'Submitter E-Mail')]/following-sibling::td[1]")
    private WebElement email;

    @FindBy(xpath = "//th[contains(., 'Priority')]/following-sibling::td[1]")
    private WebElement priority;

    @FindBy(id = "ticket-description")
    private WebElement description;

    public TicketPage() {
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(title));
    }

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        Assert.assertTrue(title.getText().contains(ticket.getTitle()),
                "Title не совпадает. Фактический текст: " + title.getText());
        Assert.assertTrue(ticketHeader.getText().contains(Dictionaries.getQueue(ticket.getQueue())),
                "Queue не совпадает. Фактический текст: " + ticketHeader.getText());
        String emailText = email.getText().trim();
        Assert.assertTrue(emailText.contains(ticket.getSubmitter_email()) || emailText.toLowerCase().contains("admin"),
                "Email/Creator не совпадает. Фактический текст: " + emailText);
        Assert.assertTrue(priority.getText().contains(Dictionaries.getPriority(ticket.getPriority())),
                "Priority не совпадает. Фактический текст: " + priority.getText());
        Assert.assertTrue(description.getText().contains(ticket.getDescription()),
                "Description не совпадает. Фактический текст: " + description.getText());
    }
}