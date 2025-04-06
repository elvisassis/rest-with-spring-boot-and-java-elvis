package br.com.elvisassis.integrationtests.swagger;

import br.com.elvisassis.config.TestConfigs;
import br.com.elvisassis.data.dto.PersonDTO;
import br.com.elvisassis.integrationtests.testconstainers.AbstractIntegrationTest;
import br.com.elvisassis.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldDisplaySwaggerUIPage() {
        var content = given()
                .basePath("/swagger-ui/index.html")
                    .port(port)
                .when()
                    .get()
                .then()
                    .statusCode(200)
                .extract()
                    .body()
                        .asString();

        assertTrue(content.contains("Swagger UI"));
    }

    //TODO criar uma classe especfica para testar a entidade Person
    @Test
    void TestPeopleFindByIdWithReturningStatus200Ok(){

       PersonDTO personDTO = given()
            .basePath("/api/person/v1/2")
                .port(port)
            .when()
                .get()
            .then()
                .statusCode(200)
            .extract()
               .as(PersonDTO.class);

       assertNotNull(personDTO);
       assertEquals("Bia", personDTO.getFirstName());
       assertEquals("Verde Reis", personDTO.getLastName());
    }


}
