package api;

import io.restassured.response.Response;
import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateTicketTest extends BaseTest {

    private final CreateTicketTest helper = new CreateTicketTest();

    @Test
    public void updateTicketTest() {
        int ticketId = createClosedTicket();

        Ticket openBody = getTicket(ticketId);
        openBody.setStatus(Status.OPEN.getCode());

        updateTicketNegative(openBody);

        Ticket after = getTicket(ticketId);
        Assert.assertEquals(after.getStatus(), Integer.valueOf(Status.CLOSED.getCode()),
                "Статус закрытого тикета изменился, несмотря на ошибку 422");
    }

    private int createClosedTicket() {
        Ticket created = createTicket(buildNewTicket(Status.CLOSED, 3));
        Assert.assertNotNull(created.getId(), "Сервер не присвоил тикету ID");
        int ticketId = created.getId();

        Ticket actual = getTicket(ticketId);
        if (actual.getStatus() == null || actual.getStatus() != Status.CLOSED.getCode()) {
            actual.setStatus(Status.CLOSED.getCode());
            given()
                    .header("Authorization", getAuthorizationHeader())
                    .body(actual)
                    .when()
                    .put("/api/tickets/{id}", ticketId)
                    .then()
                    .statusCode(200);
        }
        return ticketId;
    }

    public void updateTicketNegative(Ticket ticket) {
        int ticketId = ticket.getId();

        Response response = given()
                .header("Authorization", getAuthorizationHeader())
                .body(ticket)
                .log().all()
                .when()
                .put("/api/tickets/{id}", ticketId)
                .then()
                .log().all()
                .extract()
                .response();

        String body = response.getBody().asString();
        System.out.println("Ответ сервера на запрещённый переход: " + body);

        Assert.assertEquals(response.getStatusCode(), 422,
                "Ожидалась ошибка 422 (запрещённый переход Closed -> Open), но получен код: "
                        + response.getStatusCode());
    }

    protected Ticket getTicket(int id) {
        return helper.getTicket(id);
    }
}