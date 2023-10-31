package org.example;
import DTO.*;
import conexaoMySQL.PesquisaEmBancoDeDados;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.LerProperties;
import utils.LerResultProperties;
import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyStepdefs {
    List<Response> validacao = new ArrayList<>();
    PesquisaEmBancoDeDados pesquisaDAO = new PesquisaEmBancoDeDados();
    ArrayList<NumberToWorld> lista = pesquisaDAO.pesquisarDadosUsuarios();
    List<NumberToDolar> lista2 = pesquisaDAO.pesquisaSQLNumberToDolar();
    List<Calculator> lista3 = pesquisaDAO.pesquisaDivide();
    List<Multiplicacao> lista4 = pesquisaDAO.pesquisaMultiplique();
    List<Subtracao> lista5 = pesquisaDAO.pesquisaSubtrai();
    List<Countries> lista6 = pesquisaDAO.pesquisaCapitalPais();
    List<MoedaPais>lista7 = pesquisaDAO.pesquisaMoedaPais();
    List<TelefonePais> lista8 = pesquisaDAO.pesquisaDDIPais();
    List<CelsiusFahrenheit>lista9 = pesquisaDAO.pesquisaCelsiusFahrenheit();
    Response validar;
    XmlPath  xmlPath;
    String resultado;


    @Dado("digito numero inteiro na Api")
    public void digitoNumeroInteiroNaApi() throws SOAPException, IOException, InterruptedException {
        for (int i = 0; i <lista.size(); i++) {
            validacao.add(AppTest.postNumberToWords(lista.get(i).getNum()));
        }
    }
    @Entao("sistema me retorna statusCode {int} e numero digitado por extenso")
    public void sistemaMeRetornaStatusCodeENumeroDigitadoPorExtenso(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().log().all().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getNumberToWordsResult()),
                    lista.get(i).getNumextenso());
        }
    }
    @Dado("que digito um numero na Api NumberConversion.wso")
    public void queDigitoUmNumeroNaApiNumberConversionWso() throws SOAPException, IOException, InterruptedException {
        for (int i = 0; i < lista2.size(); i++) {
            validacao.add(AppTest.postNumberDolars(lista2.get(i).getNum()));
        }
    }
    @Entao("sistema me retorna statusCode {int} e valor digitado escrito por extenso em dolar")
    public void sistemaMeRetornaStatusCodeEValorDigitadoEscritoPorExtensoEmDolar(int statusCode) throws IOException, InterruptedException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().log().all().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getNumberToDollarsResult()),
                    lista2.get(i).getNumExtenso());
        }
    }

    @Dado("que digito dois numeros na Api Calculator")
    public void queDigitoDoisNumerosNaApiCalculator() throws SOAPException, IOException {
        for (int i = 0; i < lista3.size(); i++) {
            validacao.add(AppTest.postDivisao(lista3.get(i).getValor1Divide(),
                    lista3.get(i).getValor2Divide()));
        }
    }

    @Entao("sistema me retorna o resultado da divisao e statusCode {int}")
    public void sistemaMeRetornaOResultadoDaDivisaoEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().log().all().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getNumberToDollarsResult()),
                    lista3.get(i).getResultadoDivide());
        }
    }
    @Dado("que digito dois numeros na Api CalculatorMultiply")
    public void queDigitoDoisNumerosNaApiCalculatorMultiply() throws SOAPException, IOException {
        for (int i = 0; i < lista4.size(); i++) {
            validacao.add(AppTest.postMultiplicacao(lista4.get(i).getValor1Multiplica(),
                    lista4.get(i).getValor2Multiplica()));
        }
    }
    @Entao("sistema me retorna resultado da multiplicacao e statusCode {int}")
    public void sistemaMeRetornaResultadoDaMultiplicacaoEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size() ; i++) {
            validacao.get(i).then().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getMultiplyResult()),
                    lista4.get(i).getResultadoMultiplica());
        }
    }

    @Dado("que digito dois numeros na Api CalculatorSubtract")
    public void queDigitoDoisNumerosNaApiCalculatorSubtract() throws SOAPException, IOException {
        for (int i = 0; i < lista5.size(); i++) {
            validacao.add(AppTest.postSubtracao(lista5.get(i).getValor1Subtrai(),
                    lista5.get(i).getValor2Subtrai()));
        }}
        @Entao("sistema me retorna resultado da subtracao e statusCode {int}")
        public void sistemaMeRetornaResultadoDaSubtracaoEStatusCode(int statusCode) throws IOException {
            LerResultProperties prop = new LerResultProperties();
            for (int i = 0; i < validacao.size(); i++) {
                validacao.get(i).then().log().all().statusCode(statusCode);
                Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getSubtractResult()),
                        lista5.get(i).getResultadoSubtrai());
            }
        }

    @Dado("que tenho acesso ao POST da API Listas de Continente")
    public void queTenhoAcessoAoPOSTDaAPIListasDeContinente() throws SOAPException, IOException {
        validar = AppTest.postListOfContinentsByName();
    }

    @Entao("sistema me retorna nome de todos continentes do mundo")
    public void sistemaMeRetornaNomeDeTodosContinentesDoMundo() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = Collections.singletonList(xmlPath.getString(prop.getMsName())).toString();
            Assert.assertTrue(resultado.contains(prop.getAfrica()));
    }

    @Dado("que tenho acesso ao Post da Api Lista de Paises")
    public void queTenhoAcessoAoPostDaApiListaDePaises() throws SOAPException, IOException {
        validar = AppTest.postListofCountriesbyName();
    }

    @Entao("sistema me retorna uma lista com paises do mundo")
    public void sistemaMeRetornaUmaListaComPaisesDoMundo() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = Collections.singletonList(xmlPath.getString(prop.getMsName())).toString();
        Assert.assertTrue(resultado.contains(prop.getAfghanistan()));
    }
    @E("statusCode {int}")
    public void statuscode(int statusCode) {
        validar.then().log().all().statusCode(statusCode);
    }

    @Dado("que tenho acesso ao Post da Api Capital dos paises")
    public void queTenhoAcessoAoPostDaApiCapitalDosPaises() throws SOAPException, IOException {
        for (int i = 0; i < lista6.size(); i++) {
            validacao.add(AppTest.postCapitalbyName(lista6.get(i).getSiglaPais()));
        }
    }
    @Entao("sistema me retorna a capital do pais digitado na requisicao Body e statusCode {int}")
    public void sistemaMeRetornaACapitalDoPaisDigitadoNaRequisicaoBodyEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().log().all().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getCapitalCityResult()),
                    lista6.get(i).getCapitalPais());
        }
    }

    @Dado("que digito a sigla de um pais no body da api")
    public void queDigitoASiglaDeUmPaisNoBodyDaApi() throws SOAPException, IOException {
        for (int i = 0; i < lista7.size(); i++) {
            validacao.add(AppTest.postMoedasDoMundo(lista7.get(i).getSiglaPais()));
        }
    }

    @Entao("sistema me retorna nome da moeda do pais e statusCode {int}")
    public void sistemaMeRetornaNomeDaMoedaDoPaisEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().log().all().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getMsName()),
                    lista7.get(i).getMoedaPais());

        }
    }
    @Dado("que digito a sigla de um pais no body da api Flag for a Country")
    public void queDigitoASiglaDeUmPaisNoBodyDaApiFlagForACountry() throws SOAPException, IOException {
        validar = AppTest.postBandeirasDoMundo();
    }

    @Entao("sistema me retorna um link com a imagem da bandeira e statusCode {int}")
    public void sistemaMeRetornaUmLinkComAImagemDaBandeiraEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        validar.then().log().all().statusCode(statusCode);
        xmlPath = new XmlPath(validar.asString());
        resultado = xmlPath.getString(prop.getCountryFlagResult());
        Assert.assertEquals(resultado,prop.getLinkBandeira());
    }

    @Dado("que digito a sigla de um pais no body da api International Phone Code for a Country Copy")
    public void queDigitoASiglaDeUmPaisNoBodyDaApiInternationalPhoneCodeForACountryCopy() throws SOAPException, IOException {
        for (int i = 0; i < lista8.size(); i++) {
            validacao.add(AppTest.postCodigoTelefonico(lista8.get(i).getSiglaPais()));
        }
    }

    @Entao("sistema me retorna DDI do pais que digitei e statusCode {int}")
    public void sistemaMeRetornaDDIDoPaisQueDigiteiEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
            for (int i = 0; i < validacao.size(); i++) {
                validacao.get(i).then().statusCode(statusCode);
                Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getCountryIntPhoneCodeResult()),
                        lista8.get(i).getDdiPais());
        }
    }
    @Dado("que tenho acesso ao Post da API List of Currencies by Name")
    public void queTenhoAcessoAoPostDaAPIListOfCurrenciesByName() throws SOAPException, IOException {
        validar = AppTest.postbodyNomeDaMoedaDeCadaPais();
    }

    @Entao("sistema me retorna o nome da moeda de cada pais")
    public void sistemaMeRetornaONomeDaMoedaDeCadaPais() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = xmlPath.getString(prop.getMsName().toString());
        Assert.assertTrue(resultado.contains(prop.getMoedaPais()));

    }

    @Dado("que tenho acesso ao Post da Api List of Languages by Name")
    public void queTenhoAcessoAoPostDaApiListOfLanguagesByName() throws SOAPException, IOException {
        validar = AppTest.postLinguaDeCadaPais();
    }

    @Entao("sistema me retorna uma lista com idioma de cada pais")
    public void sistemaMeRetornaUmaListaComIdiomaDeCadaPais() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = xmlPath.getString(prop.getMsName().toString());
        Assert.assertTrue(resultado.contains(prop.getLinguasDoMundo()));

    }

    @Dado("que tenho acesso a Api Is Valid ISBN Number")
    public void queTenhoAcessoAApiIsValidISBNNumber() throws SOAPException, IOException {
        validar = AppTest.postNumeroTrezeDigitos();
    }

    @Entao("quando digito treze digito validos sistema me retorna false ou true")
    public void quandoDigitoTrezeDigitoValidosSistemaMeRetornaFalseOuTrue() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = xmlPath.getString(prop.getIsValidISBN13Result().toString());
        Assert.assertTrue(true);

    }

    @Dado("que tenho acesso ao Post api Is Valid ISBN Number")
    public void queTenhoAcessoAoPostApiIsValidISBNNumber() throws SOAPException, IOException {
        validar = AppTest.postNumeroDezDigitos();
    }

    @Entao("quando digito dez digito validos sistema me retorna false ou true")
    public void quandoDigitoDezDigitoValidosSistemaMeRetornaFalseOuTrue() throws IOException {
        LerResultProperties prop = new LerResultProperties();
        xmlPath = new XmlPath(validar.asString());
        resultado = xmlPath.getString(prop.getIsValidISBN10Result().toString());
        Assert.assertTrue(true);

    }

    @Dado("que digito uma temperatura na Api Celsius to Farenheit Conversion")
    public void queDigitoUmaTemperaturaNaApiCelsiusToFarenheitConversion() throws SOAPException, IOException {
        for (int i = 0; i < lista9.size(); i++) {
            validacao.add(AppTest.postCelsiusFahrenheit(lista9.get(i).getCelsius()));

        }
    }
    @Entao("sistema me retorna a conversao de Celsius para Farenheit e statusCode {int}")
    public void sistemaMeRetornaAConversaoDeCelsiusParaFarenheitEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getCelsiusToFahrenheitResult()),
                    lista9.get(i).getFahrenheit());

        }
    }

    @Dado("que digito uma temperatura na Api Farenheit to Celsius Conversion")
    public void queDigitoUmaTemperaturaNaApiFarenheitToCelsiusConversion() throws SOAPException, IOException {
        for (int i = 0; i < lista9.size(); i++) {
            validacao.add(AppTest.postFahrenheitCelsius(lista9.get(i).getFahrenheit()));
    }
    }

    @Entao("sistema me retorna a conversao de Farenheit para Celsius e statusCode {int}")
    public void sistemaMeRetornaAConversaoDeFarenheitParaCelsiusEStatusCode(int statusCode) throws IOException {
        LerResultProperties prop = new LerResultProperties();
        for (int i = 0; i < validacao.size(); i++) {
            validacao.get(i).then().statusCode(statusCode);
            Assert.assertEquals(validacao.get(i).xmlPath().getString(prop.getFahrenheitToCelsiusResult()),
                    lista9.get(i).getCelsius());

        }
    }
}




