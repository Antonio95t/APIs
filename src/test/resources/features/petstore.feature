Feature: Validar la funcionalidad del API Store en PetStore

  @PetStore
  Scenario Outline: Creación de una Order en la tienda metodo POST
    When creo el pedido '<id>' con el id '<petID>' de la mascota
    Then la respuesta debe tener un status code <requestCode>
    And el tipo es '<tipo>'

    Examples:
      | id | petID | requestCode | tipo   |
      | 1  | 205   | 200         | placed |
      | 2  | 502   | 200         | placed |

  @Consultar
    Scenario Outline: Consulta de una Order en la tienda metodo GET
      When consulto el '<id>' de la order
      Then la respuesta es <requestCode>
      And tipo es <quantity>

      Examples:
        | id | requestCode | quantity |
        | 1  | 200         | 0        |
        | 2  | 200         | 1        |