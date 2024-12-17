package com.nttdata.glue;

import com.nttdata.steps.Pedido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class crearPedido_stepDef {
    @Steps
    Pedido crearPedido;
    //#########################################CREACION##########################################################

    @When("creo el pedido {string} con el id {string} de la mascota")
    public void creoElPedidoConElIdDeLaMascota(String id, String petID) {
        crearPedido.crearPedidos(id,petID);
    }

    @Then("la respuesta debe tener un status code {}")
    public void laRespuestaDebeTenerUnStatusCode(int requestCode) {
        crearPedido.validarCodigo(requestCode);
    }

    //###########################################################################################################

    @And("el tipo es {string}")
    public void elTipoEs(String tipo) {
        crearPedido.validarTipo(tipo);
    }

    //#########################################CONSULTAS########################################################
    @When("consulto el {string} de la order")
    public void consultoElDeLaOrder(String id) {
        crearPedido.consultarOrden(id);
    }

    @Then("la respuesta es {}")
    public void laRespuestaEs(int GetrequestCode) {
        crearPedido.validarCodPedido(GetrequestCode);
    }

    @And("tipo es {}")
    public void tipoEs(int quantity) {
        crearPedido.validarTipoConsulta(quantity);
    }
}
