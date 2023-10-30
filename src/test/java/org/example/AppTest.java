package org.example;

import io.restassured.response.Response;
import org.example.metodos.SoapEmJava;
import utils.LerProperties;
import javax.xml.soap.*;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class AppTest {

    public static Response postNumberToWords(String numero) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyNumberWord(numero))
                .when()
                .post(prop.getURLnumber())
                .then()
                .extract().response();
    }
    public static Response postNumberDolars(String numero) throws SOAPException, IOException, InterruptedException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyNumberDolar(numero))
                .when()
                .post(prop.getURLnumber())
                .then()
                .extract().response();
    }
    public static Response postDivisao(String valor1, String valor2) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.calcularDivisao(valor1,valor2))
                .when()
                .post(prop.getURLCalculator())
                .then()
                .extract().response();
    }
    public static Response postMultiplicacao(String valor1, String valor2) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.calcularMultiplicacao(valor1,valor2))
                .when()
                .post(prop.getURLCalculator())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postSubtracao() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.calcularSubtracao())
                .when()
                .post(prop.getURLCalculator())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postListOfContinentsByName() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyListOfContinentsByName())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postListofCountriesbyName () throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyCountriesbyName())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postCapitalbyName () throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyCaptialCityforCountry())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postMoedasDoMundo () throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyMoedasDoMundo())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postBandeirasDoMundo () throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyBandeirasDoMundo())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postCodigoTelefonico () throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyCodigoTelefonico())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postbodyNomeDaMoedaDeCadaPais() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyNomeDaMoedaDeCadaPais())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postLinguaDeCadaPais() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyLinguaDeCadaPais())
                .when()
                .post(prop.getURLcontinents())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postNumeroTrezeDigitos() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyNumeroTrezeDigitos())
                .when()
                .post(prop.getURLbookISBN())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postNumeroDezDigitos() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyNumeroDezDigitos())
                .when()
                .post(prop.getURLbookISBN())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postCelsiusFahrenheit() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyCelsiusFahrenheit())
                .when()
                .post(prop.getURLtemperature())
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postFahrenheitCelsius() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        return given()
                .contentType(prop.getTextXML())
                .body(SoapEmJava.bodyFahrenheitCelsius())
                .when()
                .post(prop.getURLtemperature())
                .then()
                .log().all()
                .extract().response();
    }
}

