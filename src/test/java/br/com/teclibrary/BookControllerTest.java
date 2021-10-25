package br.com.teclibrary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookControllerTest {

    @Test
    public void testEndpoint() {
        given()
                .when().get("/book")
                .then()
                .statusCode(200);
    }

}