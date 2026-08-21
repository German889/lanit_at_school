package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTicketPage extends HelpdeskBasePage {

    @FindBy(id = "id_queue")
    private WebElement selectQueue;

    @FindBy(id = "id_title")
    private WebElement inputProblem;

    @FindBy(id = "id_body")
    private WebElement inputDescription;

    @FindBy(id = "id_priority")
    private WebElement selectPriority;

    @FindBy(id = "id_due_date")
    private WebElement inputDueDate;

    @FindBy(id = "id_submitter_email")
    private WebElement inputEmail;

    @FindBy(css = "button[type='submit'], input[type='submit']")
    private WebElement submitTicketButton;

    public CreateTicketPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Создать тикет")
    public CreateTicketPage createTicket(Ticket ticket) {
        setQueue(ticket.getQueue());
        setInputProblem(ticket.getTitle());
        setInputDescription(ticket.getDescription());
        setPriority(ticket.getPriority());
        setDueDate(ticket.getDue_date());
        setEmail(ticket.getSubmitter_email());
        clickOnSubmitButton();
        return this;
    }

    @Step("Выбрать очередь")
    private void setQueue(Integer queue) {
        new Select(selectQueue).selectByValue(String.valueOf(queue));
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.click();
        inputProblem.clear();
        inputProblem.sendKeys(text);

        if (!inputProblem.getAttribute("value").equals(text)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputProblem, text);
        }
    }

    @Step("Ввести описание проблемы")
    private void setInputDescription(String text) {
        inputDescription.click();
        inputDescription.clear();
        inputDescription.sendKeys(text);

        if (!inputDescription.getAttribute("value").equals(text)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputDescription, text);
        }
    }

    @Step("Выбрать приоритет")
    private void setPriority(Integer priority) {
        new Select(selectPriority).selectByValue(String.valueOf(priority));
    }

    @Step("Ввести дату")
    private void setDueDate(String date) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputDueDate, date);
    }

    @Step("Ввести email")
    private void setEmail(String email) {
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

        if (!inputEmail.getAttribute("value").equals(email)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputEmail, email);
        }
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
    }
}