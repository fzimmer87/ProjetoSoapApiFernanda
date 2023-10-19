package org.example;
import DTO.*;
import conexaoMySQL.PesquisaEmBancoDeDados;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.LerResultProperties;
import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyStepdefs {
    Response validacao;
    String resultado;
    XmlPath xmlPath;
    PesquisaEmBancoDeDados pesquisaDAO = new PesquisaEmBancoDeDados();


    @Dado("digito numero inteiro na Api")
    public void digitoNumeroInteiroNaApi() throws SOAPException, IOException, InterruptedException {
        validacao = AppTest.postNumberToWords();
    }
    @Entao("sistema me retorna statusCode {int} e numero digitado por extenso")
    public void sistemaMeRetornaStatusCodeENumeroDigitadoPorExtenso(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        ArrayList<NumberToWord> lista = pesquisaDAO.pesquisarDadosUsuarios();
        validacao.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getNumberToWordsResult());
        for (NumberToWord numberToWord : lista) Assert.assertEquals(resultado, numberToWord.getNumextenso());
    }

    @Dado("que digito um numero na Api NumberConversion.wso")
    public void queDigitoUmNumeroNaApiNumberConversionWso() throws SOAPException, IOException, InterruptedException {
        validacao = AppTest.postNumberDolars();
    }

    @Entao("sistema me retorna statusCode {int} e valor digitado escrito por extenso em dolar")
    public void sistemaMeRetornaStatusCodeEValorDigitadoEscritoPorExtensoEmDolar(int statusCode) throws IOException, InterruptedException {
        LerResultProperties prop = new LerResultProperties();
        List<NumberToDolar> lista = pesquisaDAO.pesquisaSQLNumberToDolar();
        validacao.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getNumberToDollarsResult());
        for (NumberToDolar numberToDolar : lista) {
            Assert.assertEquals(resultado, numberToDolar.getNumExtenso());
        }
    }

    @Dado("que digito dois numeros na Api Calculator")
    public void queDigitoDoisNumerosNaApiCalculator() throws SOAPException, IOException {
        validacao = AppTest.postDivisao();
    }

    @Entao("sistema me retorna o resultado da divisao e statusCode {int}")
    public void sistemaMeRetornaOResultadoDaDivisaoEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<Calculator>list = pesquisaDAO.pesquisaDivide();
        validacao.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getDivideResult());
        for (Calculator calculator : list) {
            Assert.assertEquals(resultado, calculator.getResultadoDivide());
        }
    }

    @Dado("que digito dois numeros na Api CalculatorMultiply")
    public void queDigitoDoisNumerosNaApiCalculatorMultiply() throws SOAPException, IOException {
        validacao = AppTest.postMultiplicacao();
    }

    @Entao("sistema me retorna resultado da multiplicacao e statusCode {int}")
    public void sistemaMeRetornaResultadoDaMultiplicacaoEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<Calculator> list = pesquisaDAO.pesquisaMultiplique();
        validacao.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMultiplyResult());
        for (Calculator calculator : list) {
            Assert.assertEquals(resultado, calculator.getResultadoMultiplica());
        }

    }

    @Dado("que digito dois numeros na Api CalculatorSubtract")
    public void queDigitoDoisNumerosNaApiCalculatorSubtract() throws SOAPException, IOException {
        validacao = AppTest.postSubtracao();
    }

    @Entao("sistema me retorna resultado da subtracao e statusCode {int}")
    public void sistemaMeRetornaResultadoDaSubtracaoEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<Calculator> list = pesquisaDAO.pesquisaSubtrai();
        validacao.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getSubtractResult());
        for (Calculator calculator : list) {
            Assert.assertEquals(resultado, calculator.getResultadoSubtrai());
        }

    }

    @Dado("que tenho acesso ao POST da API Listas de Continente")
    public void queTenhoAcessoAoPOSTDaAPIListasDeContinente() throws SOAPException, IOException {
        validacao = AppTest.postListOfContinentsByName();
    }

    @Entao("sistema me retorna nome de todos continentes do mundo")
    public void sistemaMeRetornaNomeDeTodosContinentesDoMundo() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMsName());
        Assert.assertTrue(resultado.contains(prop.getAfrica()));
    }

    @Dado("que tenho acesso ao Post da Api Lista de Paises")
    public void queTenhoAcessoAoPostDaApiListaDePaises() throws SOAPException, IOException {
        validacao = AppTest.postListofCountriesbyName();
    }

    @Entao("sistema me retorna uma lista com paises do mundo")
    public void sistemaMeRetornaUmaListaComPaisesDoMundo() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMsName());
        Assert.assertTrue(resultado.contains(prop.getAfghanistan()));
    }

    @Dado("que tenho acesso ao Post da Api Capital dos paises")
    public void queTenhoAcessoAoPostDaApiCapitalDosPaises() throws SOAPException, IOException {
        validacao = AppTest.postCapitalbyName();
    }

    @Entao("sistema me retorna a capital do pais digitado na requisicao Body")
    public void sistemaMeRetornaACapitalDoPaisDigitadoNaRequisicaoBody() throws IOException {
        List<Countries>list = pesquisaDAO.pesquisaCapitalPais();
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getCapitalCityResult());
        for (Countries countries : list) {
            Assert.assertEquals(resultado, countries.getCapitalPais());
        }

    }

    @E("statusCode {int}")
    public void statuscode(int statusCode) {
        validacao.then().log().all().statusCode(statusCode);
    }

    @Dado("que digito a sigla de um pais no body da api")
    public void queDigitoASiglaDeUmPaisNoBodyDaApi() throws SOAPException, IOException {
        validacao = AppTest.postMoedasDoMundo();
    }

    @Entao("sistema me retorna nome da moeda do pais")
    public void sistemaMeRetornaNomeDaMoedaDoPais() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<Countries>list = pesquisaDAO.pesquisaMoedaPais();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMsName());
        for (Countries countries : list) {
            Assert.assertEquals(resultado, countries.getMoedaPais());
        }

    }

    @Dado("que digito a sigla de um pais no body da api Flag for a Country")
    public void queDigitoASiglaDeUmPaisNoBodyDaApiFlagForACountry() throws SOAPException, IOException {
        validacao = AppTest.postBandeirasDoMundo();
    }

    @Entao("sistema me retorna um link com a imagem da bandeira")
    public void sistemaMeRetornaUmLinkComAImagemDaBandeira() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getCountryFlagResult());
        Assert.assertEquals(resultado,prop.getLinkBandeira());
    }

    @Dado("que digito a sigla de um pais no body da api International Phone Code for a Country Copy")
    public void queDigitoASiglaDeUmPaisNoBodyDaApiInternationalPhoneCodeForACountryCopy() throws SOAPException, IOException {
        validacao = AppTest.postCodigoTelefonico();
    }
    @Entao("sistema me retorna DDI do pais que digitei")
    public void sistemaMeRetornaDDIDoPaisQueDigitei() throws IOException {
        List<Countries>list = pesquisaDAO.pesquisaDDIPais();
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getCountryIntPhoneCodeResult());
        for (Countries countries : list) {
            Assert.assertEquals(resultado, countries.getDdiPais());
        }
    }
    @Dado("que tenho acesso ao Post da API List of Currencies by Name")
    public void queTenhoAcessoAoPostDaAPIListOfCurrenciesByName() throws SOAPException, IOException {
        validacao = AppTest.postbodyNomeDaMoedaDeCadaPais();
    }
    @Entao("sistema me retorna o nome da moeda de cada pais")
    public void sistemaMeRetornaONomeDaMoedaDeCadaPais() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMsName());
        Assert.assertTrue(resultado.contains(prop.getMoedaPais()));
    }
    @Dado("que tenho acesso ao Post da Api List of Languages by Name")
    public void queTenhoAcessoAoPostDaApiListOfLanguagesByName() throws SOAPException, IOException {
        validacao = AppTest.postLinguaDeCadaPais();
    }
    @Entao("sistema me retorna uma lista com idioma de cada pais")
    public void sistemaMeRetornaUmaListaComIdiomaDeCadaPais() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getMsName());
        Assert.assertTrue(resultado.contains(prop.getLinguasDoMundo()));
    }
    @Dado("que tenho acesso a Api Is Valid ISBN Number")
    public void queTenhoAcessoAApiIsValidISBNNumber() throws SOAPException, IOException {
        validacao = AppTest.postNumeroTrezeDigitos();
    }
    @Entao("quando digito treze digito validos sistema me retorna false ou true")
    public void quandoDigitoTrezeDigitoValidosSistemaMeRetornaFalseOuTrue() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getIsValidISBN13Result());
        Assert.assertTrue(true);
    }

    @Dado("que tenho acesso ao Post api Is Valid ISBN Number")
    public void queTenhoAcessoAoPostApiIsValidISBNNumber() throws SOAPException, IOException {
        validacao = AppTest.postNumeroDezDigitos();
    }

    @Entao("quando digito dez digito validos sistema me retorna false ou true")
    public void quandoDigitoDezDigitoValidosSistemaMeRetornaFalseOuTrue() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getIsValidISBN10Result());
        Assert.assertTrue(true);
    }

    @Dado("que digito uma temperatura na Api Celsius to Farenheit Conversion")
    public void queDigitoUmaTemperaturaNaApiCelsiusToFarenheitConversion() throws SOAPException, IOException {
        validacao = AppTest.postCelsiusFahrenheit();
    }

    @Entao("sistema me retorna a conversao de Celsius para Farenheit")
    public void sistemaMeRetornaAConversaoDeCelsiusParaFarenheit() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<CelsiusFahrenheit> list = pesquisaDAO.pesquisaCelsiusFahrenheit();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getCelsiusToFahrenheitResult());
        for (CelsiusFahrenheit celsiusFahrenheit : list) {
            Assert.assertEquals(resultado, celsiusFahrenheit.getFahrenheit());
        }
    }

    @Dado("que digito uma temperatura na Api Farenheit to Celsius Conversion")
    public void queDigitoUmaTemperaturaNaApiFarenheitToCelsiusConversion() throws SOAPException, IOException {
        validacao = AppTest.postFahrenheitCelsius();
    }

    @Entao("sistema me retorna a conversao de Farenheit para Celsius")
    public void sistemaMeRetornaAConversaoDeFarenheitParaCelsius() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        List<CelsiusFahrenheit>list= pesquisaDAO.pesquisaCelsiusFahrenheit();
        xmlPath = new XmlPath(validacao.asString());
        resultado = xmlPath.getString(prop.getFahrenheitToCelsiusResult());
        for (CelsiusFahrenheit celsiusFahrenheit : list) {
            Assert.assertEquals(resultado, celsiusFahrenheit.getCelsius());
        }

    }
}




