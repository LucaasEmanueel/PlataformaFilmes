@login
Feature: Login na plataforma
  Testes da API de Login

  @loginvalido
  Scenario: Realizar login com sucesso
    Given que tenha um payload valida da API de Login
    When envio uma requisicao do tipo POST
    Then valido que recebo status 200 no response
    And armazeno o token que recebo do response do Login

  @logininvalido
  Scenario Outline: Retirar login com <cenario>
    Given que tenha um payload da API de Login  com as seguintes informações
      | email | <email> |
      | senha | <senha> |
    When envio uma requisicao do tipo POST
    Then valido que recebo status 400 no response

    Examples:
      | cenario          | email              |  | senha    |
      | usuario invalido | invalido@email.com |  | 123456   |
      | senha invalida   | aluno@email.com    |  | invalido |

