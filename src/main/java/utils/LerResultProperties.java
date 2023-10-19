package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LerResultProperties {
    String numberToWordsResult;
    String numberToDollarsResult;
    String divideResult;
    String multiplyResult;
    String subtractResult;
    String msName;
    String capitalCityResult;
    String countryFlagResult;
    String countryIntPhoneCodeResult;
    String isValidISBN13Result;
    String isValidISBN10Result;
    String celsiusToFahrenheitResult;
    String fahrenheitToCelsiusResult;
    String africa;
    String afghanistan;
    String linkBandeira;
    String moedaPais;
    String linguasDoMundo;
    private Properties prop = new Properties();

    public LerResultProperties() throws IOException{

        prop.load(Files.newInputStream(Paths.get("src/test/resources/properties/RESULT.properties")));

        this.numberToWordsResult = prop.getProperty("numberToWordsResult");
        this.numberToDollarsResult = prop.getProperty("numberToDollarsResult");
        this.divideResult = prop.getProperty("divideResult");
        this.multiplyResult = prop.getProperty("multiplyResult");
        this.subtractResult = prop.getProperty("subtractResult");
        this.msName = prop.getProperty("msName");
        this.capitalCityResult = prop.getProperty("capitalCityResult");
        this.countryFlagResult = prop.getProperty("countryFlagResult");
        this.countryIntPhoneCodeResult = prop.getProperty("countryIntPhoneCodeResult");
        this.isValidISBN13Result = prop.getProperty("isValidISBN13Result");
        this.isValidISBN10Result = prop.getProperty("isValidISBN10Result");
        this.celsiusToFahrenheitResult = prop.getProperty("celsiusToFahrenheitResult");
        this.fahrenheitToCelsiusResult = prop.getProperty("fahrenheitToCelsiusResult");
        this.africa = prop.getProperty("africa");
        this.afghanistan = prop.getProperty("afghanistan");
        this.linkBandeira = prop.getProperty("linkBandeira");
        this.moedaPais = prop.getProperty("moedaPais");
        this.linguasDoMundo = prop.getProperty("linguasDoMundo");
    }

    public String getNumberToWordsResult() {
        return numberToWordsResult;
    }

    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }

    public String getDivideResult() {
        return divideResult;
    }

    public String getMultiplyResult() {
        return multiplyResult;
    }

    public String getSubtractResult() {
        return subtractResult;
    }

    public String getMsName() {
        return msName;
    }

    public String getCapitalCityResult() {
        return capitalCityResult;
    }

    public String getCountryFlagResult() {
        return countryFlagResult;
    }

    public String getCountryIntPhoneCodeResult() {
        return countryIntPhoneCodeResult;
    }

    public String getIsValidISBN13Result() {
        return isValidISBN13Result;
    }

    public String getIsValidISBN10Result() {
        return isValidISBN10Result;
    }

    public String getCelsiusToFahrenheitResult() {
        return celsiusToFahrenheitResult;
    }

    public String getFahrenheitToCelsiusResult() {
        return fahrenheitToCelsiusResult;
    }

    public String getAfrica() {
        return africa;
    }
    public String getAfghanistan(){
        return afghanistan;
    }

    public String getLinkBandeira() {
        return linkBandeira;
    }

    public String getMoedaPais() {
        return moedaPais;
    }

    public String getLinguasDoMundo() {
        return linguasDoMundo;
    }
}
