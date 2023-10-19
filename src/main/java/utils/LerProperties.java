package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LerProperties {
    String URLnumber;
    String URLCalculator;
    String URLcontinents;
    String URLbookISBN;
    String URLtemperature;
    String numbersURI;
    String calculatorURI;
    String continetsCountryURI;
    String numbersISBNURI;
    String temperatureURI;
    String textXML;
    String web;
    String numberToWords;
    String ubiNum;
    String numberToDollars;
    String dNum;
    String divide;
    String intANumber;
    String intBNumber;
    String multiply;
    String subtract;
    String listOfContinentsByName;
    String soap12 ;
    String listOfCountryNamesByName;
    String capitalCity;
    String soapEndPoint;
    String scountryISOCode;
    String countryCurrency;
    String countryFlag;
    String countryIntPhoneCode;
    String listOfCurrenciesByName;
    String listOfLanguagesByName;
    String isValidISBN13;
    String sISBNumber;
    String isValidISBN10;
    String celsiusToFahrenheit;
    String celsius;
    String fahrenheitToCelsius;
    String fahrenheit;
    String numerosteste13;
    String numeroteste10;

    private Properties prop = new Properties();


    public LerProperties() throws IOException {

        prop.load(Files.newInputStream(Paths.get("src/test/resources/properties/URL.properties")));
        prop.load(Files.newInputStream(Paths.get("src/test/resources/properties/URI.properties")));
        prop.load(Files.newInputStream(Paths.get("src/test/resources/properties/SOAP.properties")));


        ///URLs///
        this.URLnumber = prop.getProperty("numberosExtenso");
        this.URLCalculator = prop.getProperty("URLCalculator");
        this.URLcontinents = prop.getProperty("continents");
        this.URLbookISBN = prop.getProperty("bookISBN");
        this.URLtemperature = prop.getProperty("temperature");


        ///URIs///
        this.numbersURI = prop.getProperty("numbersURI");
        this.calculatorURI = prop.getProperty("calculator");
        this.continetsCountryURI = prop.getProperty("continetsCountry");
        this.numbersISBNURI = prop.getProperty("numbersISBN");
        this.temperatureURI = prop.getProperty("temperatureURI");
        this.textXML = prop.getProperty("textXML");

        ///SOAPs///
        this.web = prop.getProperty("web");
        this.numberToWords = prop.getProperty("numberToWords");
        this.ubiNum = prop.getProperty("ubiNumSoap");
        this.numberToDollars = prop.getProperty("numberToDollars");
        this.dNum = prop.getProperty("dNumber");
        this.divide = prop.getProperty("divideNumber");
        this.intANumber = prop.getProperty("intANumber");
        this.intBNumber = prop.getProperty("intBNumber");
        this.multiply = prop.getProperty("multiply");
        this.subtract = prop.getProperty("subtract");
        this.listOfContinentsByName = prop.getProperty("listOfContinentsByName");
        this.soap12 = prop.getProperty("soap.12");
        this.listOfCountryNamesByName = prop.getProperty("listOfCountryNamesByName");
        this.capitalCity = prop.getProperty("capitalCity");
        this.soapEndPoint = prop.getProperty("soapEndPoint");
        this.scountryISOCode = prop.getProperty("scountryISOCode");
        this.countryCurrency = prop.getProperty("countryCurrency");
        this.countryFlag = prop.getProperty("countryFlag");
        this.countryIntPhoneCode = prop.getProperty("countryIntPhoneCode");
        this.listOfCurrenciesByName = prop.getProperty("listOfCurrenciesByName");
        this.listOfLanguagesByName = prop.getProperty("listOfLanguagesByName");
        this.isValidISBN13 = prop.getProperty("isValidISBN13");
        this.sISBNumber = prop.getProperty("sISBNumber");
        this.isValidISBN10 = prop.getProperty("isValidISBN10");
        this.celsiusToFahrenheit = prop.getProperty("celsiusToFahrenheit");
        this.celsius = prop.getProperty("celsius");
        this.fahrenheitToCelsius = prop.getProperty("fahrenheitToCelsius");
        this.fahrenheit = prop.getProperty("fahrenheit");
        this.numerosteste13 = prop.getProperty("numerosteste13");
        this.numeroteste10 = prop.getProperty("numeroteste10");

    }
    ///URLs///
    public String getURLnumber() {
        return this.URLnumber;
    }

    public String getURLCalculator() {
        return this.URLCalculator;
    }

    public String getURLcontinents() {
        return this.URLcontinents;
    }

    public String getURLbookISBN() {
        return this.URLbookISBN;
    }
    public String getURLtemperature() {
        return URLtemperature;
    }


    ///URIs///
    public String getNumbersURI() {
        return numbersURI;
    }

    public String getCalculatorURI() {
        return calculatorURI;
    }

    public String getContinetsCountryURI() {
        return continetsCountryURI;
    }

    public String getNumbersISBNURI() {
        return numbersISBNURI;
    }

    public String getTemperatureURI() {
        return temperatureURI;
    }

    public String getTextXML() {
        return textXML;
    }

    public String getWeb() {
        return web;
    }

    public String getNumberToWords() {
        return numberToWords;
    }
    public String getUbiNum() {
        return ubiNum;
    }

    public String getNumberToDollars() {
        return numberToDollars;
    }
    public String getdNum() {
        return dNum;
    }
    public String getDivide() {
        return divide;
    }

    public String getIntANumber() {
        return intANumber;
    }

    public String getIntBNumber() {
        return intBNumber;
    }

    public String getMultiply() {
        return multiply;
    }

    public String getSubtract() {
        return subtract;
    }

    public String getListOfContinentsByName() {
        return listOfContinentsByName;
    }

    public String getSoap12() {
        return soap12;
    }

    public String getListOfCountryNamesByName() {
        return listOfCountryNamesByName;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getSoapEndPoint() {
        return soapEndPoint;
    }

    public String getScountryISOCode() {
        return scountryISOCode;
    }

    public String getCountryCurrency() { return countryCurrency;}

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getCountryIntPhoneCode() {
        return countryIntPhoneCode;
    }

    public String getListOfCurrenciesByName() {
        return listOfCurrenciesByName;
    }
    public String getListOfLanguagesByName(){return listOfLanguagesByName;}

    public String getIsValidISBN13() {
        return isValidISBN13;
    }

    public String getsISBNumber() {
        return sISBNumber;
    }

    public String getIsValidISBN10() {
        return isValidISBN10;
    }

    public String getCelsiusToFahrenheit() {
        return celsiusToFahrenheit;
    }

    public String getCelsius() {
        return celsius;
    }

    public String getFahrenheitToCelsius() {
        return fahrenheitToCelsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }

    public String getNumerosteste13() {
        return numerosteste13;
    }

    public String getNumeroteste10() {
        return numeroteste10;
    }
}

