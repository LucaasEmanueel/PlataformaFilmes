@categorias @all
Feature: lista de categorias
  Buscando a lista de categorias

  @listacategorias
  Scenario: Realizar consulta de categorias com sucesso
    Given que tenha usado o login com dados validos
    And tenha um payload da API de categorias
    When envio uma requisicao do tipo GET de categoria
    Then valido que recebo status 200 no response
    And valido que no campo "tipo[2]" possui o valor "Terror"

  Scenario: Realizar consultas de categorias sem o token
    When envio uma requisicao do tipo GET de categoria
    Then valido que recebo status 403 no response
    And valido que no campo "message" possui o valor "Access Denied"

  Scenario: Realizar consultas de categorias com token invalido
    Given altere o campo "Authorization" para "invalido" do header de categoria
    When envio uma requisicao do tipo GET de categoria
    Then valido que recebo status 403 no response
    And valido que no campo "message" possui o valor "Access Denied"