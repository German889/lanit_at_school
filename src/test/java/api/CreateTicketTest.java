package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        int testPriority = 3;
        Ticket newTicket = buildNewTicket(Status.OPEN, testPriority);

        String expectedTitle = newTicket.getTitle();
        Integer expectedQueue = newTicket.getQueue();

        System.out.println("Создаём тикет: " + expectedTitle);

        Ticket createdTicket = createTicket(newTicket);

        Assert.assertNotNull(createdTicket.getId(),
                "ID тикета не был присвоен сервером");
        Assert.assertNotNull(createdTicket.getCreated(),
                "Поле 'created' не было установлено сервером");

        System.out.println("Тикет успешно создан. ID = " + createdTicket.getId());

        Ticket retrievedTicket = getTicket(createdTicket.getId());

        Assert.assertNotNull(retrievedTicket,
                "Тикет с ID " + createdTicket.getId() + " не был найден в системе");

        Assert.assertEquals(retrievedTicket.getId(), createdTicket.getId(),
                "ID тикета не совпадает");
        Assert.assertEquals(retrievedTicket.getTitle(), expectedTitle,
                "Заголовок тикета изменился после создания");
        Assert.assertEquals(retrievedTicket.getQueue(), expectedQueue,
                "Очередь тикета изменилась");
        Assert.assertEquals(retrievedTicket.getPriority(), Integer.valueOf(testPriority),
                "Приоритет тикета изменился");

        System.out.println("Тикет успешно найден и проверен: " + retrievedTicket);
    }

}