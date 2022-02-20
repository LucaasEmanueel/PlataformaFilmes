Feature: lista de categorias
  Scenario: Listar as categorias existentes
    Given acesso a payload da API
    When encontro com o usuario
    And salvo o token
    And busca a lista com o metodo "GET"
    Then valido se o codigo da resposta vem "200"