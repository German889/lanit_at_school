package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.AuthToken;
import model.Status;
import model.Ticket;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    private String cachedToken;

    @BeforeClass
    public void prepare() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить config.properties", e);
        }

        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .build();

        RestAssured.filters(new ResponseLoggingFilter(LogDetail.STATUS));
    }

    protected AuthToken login() {
        if (cachedToken != null && !cachedToken.isEmpty()) {
            AuthToken token = new AuthToken();
            token.setToken(cachedToken);
            return token;
        }

        String username = System.getProperty("username");
        String password = System.getProperty("password");

        if (username == null || password == null) {
            throw new RuntimeException("В config.properties отсутствуют username или password");
        }

        AuthToken credentials = new AuthToken();
        credentials.setUsername(username);
        credentials.setPassword(password);

        String token = given()
                .body(credentials)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Не удалось получить токен авторизации");
        }

        cachedToken = token;

        AuthToken response = new AuthToken();
        response.setToken(token);
        return response;
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        Ticket ticket = new Ticket();

        ticket.setTitle("Test Ticket " + UUID.randomUUID().toString().substring(0, 8));
        ticket.setQueue(1);

        ticket.setStatus(status.getCode());
        ticket.setPriority(priority);

        ticket.setDescription("Automated test ticket description");
        ticket.setSubmitter_email("test@example.com");

        return ticket;
    }

    protected Ticket createTicket(Ticket ticket) {
        String authorizationHeader = getAuthorizationHeader();

        return given()
                .header("Authorization", authorizationHeader)
                .body(ticket)
                .when()
                .post("/api/tickets")
                .then()
                .statusCode(201)
                .extract()
                .as(Ticket.class);
    }

    protected String getAuthorizationHeader() {
        AuthToken authToken = login();
        return "token " + authToken.getToken();
    }

    protected Ticket getTicket(int id) {
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

        response.then().statusCode(200);
        return response.as(Ticket.class);
    }
}