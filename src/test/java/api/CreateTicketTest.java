package api;

import io.restassured.response.Response;
import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        int testPriority = 3;
        Ticket newTicket = buildNewTicket(Status.OPEN, testPriority);

        String expectedTitle = newTicket.getTitle();
        Integer expectedQueue = newTicket.getQueue();

        Ticket createdTicket = createTicket(newTicket);

        Assert.assertNotNull(createdTicket.getId(),
                "ID тикета не был присвоен сервером");
        Assert.assertNotNull(createdTicket.getCreated(),
                "Поле 'created' не было установлено сервером");

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
    }

    public Ticket getTicket(int id) {
        Response response = given()
                .pathParam("id", id)
                .when()
                .get("/api/tickets/{id}");

        if (response.getStatusCode() == 401) {
            response = given()
                    .header("Authorization", getAuthorizationHeader())
                    .pathParam("id", id)
                    .when()
                    .get("/api/tickets/{id}");
        }

        if (response.getStatusCode() == 404) {
            return null;
        }

        Assert.assertEquals(response.getStatusCode(), 200,
                "Неожиданный код ответа при получении тикета: " + response.getStatusCode());

        return response.as(Ticket.class);
    }
}