package com.datapar;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.jboss.resteasy.util.HttpHeaderNames.ACCEPT;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UsuarioResourceTest {

    @Test
    public void shouldGetAllUsuarios() {
        given()
                .header(ACCEPT, APPLICATION_JSON).
                when()
                .get("api/v1/usuarios").
                then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    public void shouldGetAUsuario() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", "f152bcd0-1cb1-4c4d-8d56-57db3fa55d47").
                when()
                .get("api/v1/usuarios/{id}").
                then()
                .statusCode(OK.getStatusCode())
                .body("nombre", is("Caballero"))
                .body("tipoUsuario", is("ADMINISTRADOR"));
    }

    @Test
    public void initializeUsuarios() {
    }
}
