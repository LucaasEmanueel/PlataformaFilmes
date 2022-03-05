@filmes @all
Feature: CRUD de Filmes

  Background:
    Given que tenha usado o login com dados validos
    And que tenha uma payload valida da API de Filmes

  @cadastrofilme
  Scenario: Cadastro de filmes
    When envio uma requisicao do tipo POST de Filmes
    Then valido que recebo status 201 no response
    And valido que no campo "categorias.tipo[1]" possui o valor "Comédia"
    And armazeno o id que recebo do response de Filme

  @consultafilme
  Scenario: Consulta Filme
    When envio uma requisicao do tipo GET de filme
    Then valido que recebo status 200 no response
    And valido que no campo "categorias[0].tipo[1]" possui o valor "Comédia"

    @alteracaofilme
   Scenario: Alteracao do filme
     And altero o indice 1 de categorias de filmes com os valores
       | tipo | Terror |
     When envio uma requisicao do tipo PUT de filme
     Then valido que recebo status 200 no response
     And valido que no campo "categorias.tipo[1]" possui o valor "Terror"

  @consultafilmeposalterado
  Scenario: Consulta Filme apos alteração
    When envio uma requisicao do tipo GET de filme
    Then valido que recebo status 200 no response
    And valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

    @removerfilme
    Scenario: Remover Filmes
      When envio uma requisicao do tipo DELETE de filme
      Then valido que recebo status 200 no response

  @consultafilmeposexcluido
  Scenario: Consulta Filme apos excluido
    When envio uma requisicao do tipo GET de filme
    Then valido que recebo status 200 no response
    And valido que recebo uma lista vazia

