package org.example.metodos;

import DTO.*;
import conexaoMySQL.PesquisaEmBancoDeDados;
import utils.LerProperties;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class SoapEmJava {
    static PesquisaEmBancoDeDados pesquisaDAO = new PesquisaEmBancoDeDados();
    public static String bodyNumberWord() throws SOAPException, IOException {
        ArrayList<NumberToWord> lista = pesquisaDAO.pesquisarDadosUsuarios();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String namespaceURI = prop.getNumbersURI();
        String namespacePrefix = prop.getWeb();

        String localName = prop.getNumberToWords();
        QName bodyName = new QName(namespaceURI, localName, namespacePrefix);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(namespaceURI, prop.getUbiNum(), namespacePrefix);
        SOAPElement symbol = bodyElement.addChildElement(name);
        for (NumberToWord numberToWord : lista) symbol.addTextNode(numberToWord.getNum());

        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String bodyNumberDolar() throws SOAPException, IOException, InterruptedException {
        List<NumberToDolar> lista = pesquisaDAO.pesquisaSQLNumberToDolar();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String namespaceURI = prop.getNumbersURI();
        String namespacePrefix = prop.getWeb();

        String localName = prop.getNumberToDollars();
        QName bodyName = new QName(namespaceURI, localName, namespacePrefix);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        QName name = new QName(namespaceURI, prop.getdNum(), namespacePrefix);
        SOAPElement symbol = bodyElement.addChildElement(name);
        for (NumberToDolar numberToDolar : lista) {
            symbol.addTextNode(numberToDolar.getNum());
        }


        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String calcularDivisao() throws SOAPException, IOException {
        List<Calculator> calculators = pesquisaDAO.pesquisaDivide();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getDivide();
        QName bodyDivide = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyDivide);
        for (Calculator calculator : calculators) {
            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(calculator.getValor1Divide());
            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(calculator.getValor2Divide());
        }

        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String calcularMultiplicacao() throws SOAPException, IOException {
        List<Calculator> list = pesquisaDAO.pesquisaMultiplique();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getMultiply();
        QName bodyMultiplica = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyMultiplica);
        for (Calculator calculator : list) {
            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(calculator.getValor1Multiplica());
            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(calculator.getValor2Multiplica());
        }
        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String calcularSubtracao() throws SOAPException, IOException {
        List<Calculator>list = pesquisaDAO.pesquisaSubtrai();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getSubtract();
        QName bodySubtrai = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodySubtrai);
        for (Calculator calculator : list) {
            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(calculator.getValor1Subtrai());

            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(calculator.getValor2Subtrai());

        }

        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyListOfContinentsByName() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getListOfContinentsByName();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyCountriesbyName() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getListOfCountryNamesByName();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);


        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyCaptialCityforCountry() throws SOAPException, IOException {
        List<Countries>list = pesquisaDAO.pesquisaCapitalPais();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCapitalCity();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        QName listaName = new QName(nomeURI, prop.getScountryISOCode(),prop.getSoapEndPoint());
        SOAPElement intAElement = bodyElement.addChildElement(listaName);
        for (Countries countries : list) {
            intAElement.addTextNode(countries.getSiglaPais());
        }

        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyMoedasDoMundo() throws SOAPException, IOException {
        List<Countries>list = pesquisaDAO.pesquisaMoedaPais();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryCurrency();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        for (Countries countries : list) {
            QName listaName = new QName(nomeURI, prop.getScountryISOCode(), prop.getSoapEndPoint());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(countries.getSiglaPais());
        }

        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyBandeirasDoMundo() throws SOAPException, IOException {
        List<Countries>list = pesquisaDAO.pesquisaMoedaPais();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryFlag();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        for (Countries countries : list) {
            QName listaName = new QName(nomeURI, prop.getScountryISOCode());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(countries.getSiglaPais());
        }

        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyCodigoTelefonico() throws SOAPException, IOException {
        List<Countries> list = pesquisaDAO.pesquisaDDIPais();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryIntPhoneCode();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        for (Countries countries : list) {
            QName listaName = new QName(nomeURI, prop.getScountryISOCode());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(countries.getSiglaPais());
        }

        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyNomeDaMoedaDeCadaPais() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getListOfCurrenciesByName();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyLinguaDeCadaPais() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getListOfLanguagesByName();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getListOfLanguagesByName());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyNumeroTrezeDigitos() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getNumbersISBNURI();
        String nomeMetodo = prop.getIsValidISBN13();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        QName listaName = new QName(nomeURI, prop.getsISBNumber());
        SOAPElement intAElement = bodyElement.addChildElement(listaName);
        intAElement.addTextNode(prop.getNumerosteste13());

        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyNumeroDezDigitos() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getNumbersISBNURI();
        String nomeMetodo = prop.getIsValidISBN10();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        QName listaName = new QName(nomeURI, prop.getsISBNumber());
        SOAPElement intAElement = bodyElement.addChildElement(listaName);
        intAElement.addTextNode(prop.getNumeroteste10());
        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyCelsiusFahrenheit() throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        List<CelsiusFahrenheit>list = pesquisaDAO.pesquisaCelsiusFahrenheit();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getTemperatureURI();
        String nomeMetodo = prop.getCelsiusToFahrenheit();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        for (CelsiusFahrenheit celsius : list) {
            QName listaName = new QName(nomeURI, prop.getCelsius());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(celsius.getCelsius());
        }
        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String bodyFahrenheitCelsius() throws SOAPException, IOException {
        List<CelsiusFahrenheit>list = pesquisaDAO.pesquisaCelsiusFahrenheit();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getTemperatureURI();
        String nomeMetodo = prop.getFahrenheitToCelsius();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
        for (CelsiusFahrenheit celsiusFahrenheit : list) {
            QName listaName = new QName(nomeURI, prop.getFahrenheit());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(celsiusFahrenheit.getFahrenheit());
        }

        try {

            StringWriter sw = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPPart()), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
