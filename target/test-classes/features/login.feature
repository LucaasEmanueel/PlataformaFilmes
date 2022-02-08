Feature: Login na plataforma
  Testes da API de Login

  Scenario: Realizar login com sucesso
    Given que tenha um payload valida da API de Login
    When envio uma requisicao do tipo POST
    Then valido que recebo status 200 no response
    And armazeno o token que recebo do response do Login

   Scenario: Retirar login com usuario invalido
     Given que tenha um payload da API de Login  com as seguintes informações
          | email | invalido@email.com|
          | senha | 123456            |
     When envio uma requisicao do tipo POST
     Then valido que recebo status 400 no response
     #Then valido que recebo "xuxa" no campo "nome"