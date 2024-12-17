package com.nttdata.steps;

import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Pedido {
    private static String url="https://petstore.swagger.io/v2/store/order";
    @Steps
    private static String url2= "https://petstore.swagger.io/v2/store/order/";
    Response response;

    public void crearPedidos(String id, String petID) {
        SerenityRest
        .given()
        .contentType("application/json")
        .body("{\n" +
                "  \"id\": \""+id+"\",\n" +
                "  \"petId\": \""+petID+"\",\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2024-12-17T02:34:01.486Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}")
                .log().all()
                .post(url)
                .then()
                .log().all();
    };

    public void validarCodigo(int requestCode) {
        restAssuredThat(response -> response.statusCode(requestCode));
    }

    public void validarTipo(String tipo) {restAssuredThat(response -> response.body("'status'", equalTo(tipo)));
        System.out.println("status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void consultarOrden(String id) {
        response=RestAssured.given().baseUri(url2).get(id).then().log().all().extract().response();
    }

    public void validarCodPedido(int GetrequestCode) {
        restAssuredThat(response -> response.statusCode(GetrequestCode));
    }

    public void validarTipoConsulta(int quantity) {
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
        System.out.println("quantity: " + SerenityRest.lastResponse().body().path("quantity").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}