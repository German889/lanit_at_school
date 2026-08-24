package ru.lanit.at.steps.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import ru.lanit.at.steps.web.AbstractWebSteps;
import ru.lanit.at.utils.web.pagecontext.PageManager;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;

public class HelpdeskWebSteps extends AbstractWebSteps {

    public HelpdeskWebSteps(PageManager pageManager) {
        super(pageManager);
    }

    @Когда("выбрать в выпадающем списке {string} значение {string}")
    public void selectDropdownByValue(String elementName, String value) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(visible).selectOptionByValue(value);
        LOGGER.info("В выпадающем списке '{}' выбрано значение '{}'", elementName, value);
    }

    @И("загрузить файл в элемент {string} из пути {string}")
    public void uploadFile(String elementName, String filePath) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        // Selenide сам реализует механизм загрузки файла через sendKeys или JS
        element.shouldBe(visible).uploadFile(new File(filePath));
        LOGGER.info("Загружен файл '{}' в элемент '{}'", filePath, elementName);
    }
}