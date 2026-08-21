package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewPage extends HelpdeskBasePage {
    @FindBy(xpath = "//th[contains(., 'Queue:')]")
    private WebElement queue;
    @FindBy(xpath = "//th[contains(., 'Submitter E-Mail')]/following-sibling::td[1]")
    private WebElement email;

    @FindBy(xpath = "//th[contains(., 'Priority')]/following-sibling::td[1]")
    private WebElement priority;

    @FindBy(xpath = "//th[contains(., 'Description')]")
    private WebElement descriptionLabel;
    private By captionLocator = By.xpath("//table/caption | //h2[contains(., 'Ticket')] | //h3[contains(., 'Ticket')]");
    private WebElement caption;

    public ViewPage() {
        PageFactory.initElements(driver, this);
        caption = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(captionLocator));
    }

    @Step("Проверить значение полей на карточке тикета")
    public ViewPage checkTicket(Ticket ticket) {
        Assert.assertTrue(getTicketTitle().contains(ticket.getTitle()), "Имя тикета не соответствует");
        Assert.assertTrue(queue.getText().contains(Dictionaries.getQueue(ticket.getQueue())),
                "Очередь не соответствует. Фактический текст: " + queue.getText());

        Assert.assertEquals(email.getText().trim(), ticket.getSubmitter_email(), "Email не соответствует");
        Assert.assertTrue(priority.getText().contains(Dictionaries.getPriority(ticket.getPriority())),
                "Приоритет не соответствует. Фактический текст: " + priority.getText());

        return this;
    }

    @Step("Получить заголовок тикета")
    public String getTicketTitle() {
        return caption.getText();
    }

    @Step("Сохранить id тикета в объект")
    public void saveId(Ticket ticket) {
        String captionText = caption.getText();
        Matcher m = Pattern.compile("(?:#|DH-)(\\d+)").matcher(captionText);
        if (m.find()) {
            ticket.setId(Integer.parseInt(m.group(1)));
        } else {
            System.out.println("Предупреждение: Не удалось извлечь ID из заголовка: " + captionText);
        }
    }
}