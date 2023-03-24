Feature: Update user information

  Scenario: Update user Information in Preview section
    Given  open browser in Developer Guide
    And user Clicks on Component Reference tab
    And search in Quick Find for "datatable"
    And click on "Data Table with Inline Edit" option in ddl
    And click on Open in Playground button
    When third row information is updated
    Then verify that information has been saved correctly

    Scenario: Hacer prueba de coneccion con mongo db
      Given conectar con mongo db
      When seleccione la base de datos
      Then imprimir la coleccion que tiene

    Scenario: obtener el primer registro una coleccion
      Given conectar con mongo db
      When se elige la base de datos "miscelanea"
      Then Imprimir el resultado

      #Scenario Outline: hacer prueba scenario outline
      #  Given abre chrome
      #  When me logueo <user> y <psw>
      #  Then navego en homescreen
      #  Examples: | user | psw|
      #            | vamtercof | V@mterc0f |
      #            | vmt2 | Vmt2123!       |