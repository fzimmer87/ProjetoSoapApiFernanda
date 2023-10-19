#language: pt
Funcionalidade: Testar API em SOAP no Java

  @CT001
  Cenario: Testar se número digitado é o mesmo que extenso do response
    Dado digito numero inteiro na Api
    Entao sistema me retorna statusCode 200 e numero digitado por extenso

  @CT002
  Cenario: Testar Api NumberConversion
    Dado que digito um numero na Api NumberConversion.wso
    Entao sistema me retorna statusCode 200 e valor digitado escrito por extenso em dolar

  @CT003
  Cenario: Testar Api CalculatorDivide
    Dado que digito dois numeros na Api Calculator
    Entao sistema me retorna o resultado da divisao e statusCode 200

  @CT004
  Cenario: Testar Api CalculatorMultiply
    Dado que digito dois numeros na Api CalculatorMultiply
    Entao sistema me retorna resultado da multiplicacao e statusCode 200

  @CT005
  Cenario: Testar Api Calculator Subtract
    Dado que digito dois numeros na Api CalculatorSubtract
    Entao sistema me retorna resultado da subtracao e statusCode 200

  @CT006
  Cenario: Testar Api List of Continents By Name
    Dado que tenho acesso ao POST da API Listas de Continente
    Entao sistema me retorna nome de todos continentes do mundo
    E statusCode 200

  @CT007
  Cenario: Testar Api List of Country Names By Name
    Dado que tenho acesso ao Post da Api Lista de Paises
    Entao sistema me retorna uma lista com paises do mundo
    E statusCode 200

  @CT008
  Cenario: Testar Api Captial City for a Country
    Dado que tenho acesso ao Post da Api Capital dos paises
    Entao sistema me retorna a capital do pais digitado na requisicao Body
    E statusCode 200

  @CT009
  Cenario: Testar Api Currency for a Country
    Dado que digito a sigla de um pais no body da api
    Entao sistema me retorna nome da moeda do pais
    E statusCode 200

  @CT010
  Cenario: Testar Api Flag for a Country
    Dado que digito a sigla de um pais no body da api Flag for a Country
    Entao sistema me retorna um link com a imagem da bandeira
    E statusCode 200

  @CT011
  Cenario: Testar Api International Phone Code for a Country Copy
    Dado que digito a sigla de um pais no body da api International Phone Code for a Country Copy
    Entao sistema me retorna DDI do pais que digitei

  @CT012
  Cenario: Testar Api List of Currencies by Name
    Dado que tenho acesso ao Post da API List of Currencies by Name
    Entao sistema me retorna o nome da moeda de cada pais
    E statusCode 200

  @CT013
  Cenario: Testar Api List of Languages by Name
    Dado que tenho acesso ao Post da Api List of Languages by Name
    Entao sistema me retorna uma lista com idioma de cada pais
    E statusCode 200

  @CT014
  Cenario: Testar Api Is Valid ISBN13 Number
    Dado que tenho acesso a Api Is Valid ISBN Number
    Entao quando digito treze digito validos sistema me retorna false ou true
    E statusCode 200

  @CT015
  Cenario: Testar Api Is Valid ISBN10 Number
    Dado que tenho acesso ao Post api Is Valid ISBN Number
    Entao quando digito dez digito validos sistema me retorna false ou true
    E statusCode 200

  @CT016
  Cenario: Testar Api Celsius to Farenheit Conversion
    Dado que digito uma temperatura na Api Celsius to Farenheit Conversion
    Entao sistema me retorna a conversao de Celsius para Farenheit
    E statusCode 200

  @CT017
  Cenario: Testar Api Farenheit to Celsius Conversion
    Dado que digito uma temperatura na Api Farenheit to Celsius Conversion
    Entao sistema me retorna a conversao de Farenheit para Celsius
    E statusCode 200


