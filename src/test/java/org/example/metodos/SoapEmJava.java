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
import java.util.List;

public class SoapEmJava {
    static PesquisaEmBancoDeDados pesquisaDAO = new PesquisaEmBancoDeDados();
    public static String bodyNumberWord(String numero) throws SOAPException, IOException {
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
            symbol.addTextNode(numero);
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

    public static String bodyNumberDolar(String numero) throws SOAPException, IOException, InterruptedException {
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
        symbol.addTextNode(numero);


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

    public static String calcularDivisao(String valor1, String valor2) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getDivide();
        QName bodyDivide = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyDivide);
            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(valor1);
            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(valor2);


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

    public static String calcularMultiplicacao(String mult1, String mult2) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();
        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getMultiply();
        QName bodyMultiplica = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyMultiplica);
            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(mult1);
            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(mult2);

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

    public static String calcularSubtracao(String valor1, String valor2) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getCalculatorURI();
        String nomeMetodo = prop.getSubtract();
        QName bodySubtrai = new QName(nomeURI, nomeMetodo);
        SOAPBodyElement bodyElement = body.addBodyElement(bodySubtrai);

            QName intAName = new QName(nomeURI, prop.getIntANumber());
            SOAPElement intAElement = bodyElement.addChildElement(intAName);
            intAElement.addTextNode(valor1);

            QName intBName = new QName(nomeURI, prop.getIntBNumber());
            SOAPElement intBElement = bodyElement.addChildElement(intBName);
            intBElement.addTextNode(valor2);


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
    public static String bodyCaptialCityforCountry(String valor1) throws SOAPException, IOException {

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
            intAElement.addTextNode(valor1);

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
    public static String bodyMoedasDoMundo(String valor1) throws SOAPException, IOException {

        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryCurrency();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
            QName listaName = new QName(nomeURI, prop.getScountryISOCode(), prop.getSoapEndPoint());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(valor1);

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
        List<MoedaPais>list = pesquisaDAO.pesquisaMoedaPais();
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryFlag();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

        for (MoedaPais countries : list) {
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
    public static String bodyCodigoTelefonico(String valor1) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getContinetsCountryURI();
        String nomeMetodo = prop.getCountryIntPhoneCode();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoapEndPoint());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

            QName listaName = new QName(nomeURI, prop.getScountryISOCode());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(valor1);


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
    public static String bodyCelsiusFahrenheit(String valor1) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getTemperatureURI();
        String nomeMetodo = prop.getCelsiusToFahrenheit();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);
            QName listaName = new QName(nomeURI, prop.getCelsius());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(valor1);

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
    public static String bodyFahrenheitCelsius(String valor1) throws SOAPException, IOException {
        LerProperties prop = new LerProperties();
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        String nomeURI = prop.getTemperatureURI();
        String nomeMetodo = prop.getFahrenheitToCelsius();
        QName bodyLista = new QName( nomeURI,nomeMetodo,prop.getSoap12());
        SOAPBodyElement bodyElement = body.addBodyElement(bodyLista);

            QName listaName = new QName(nomeURI, prop.getFahrenheit());
            SOAPElement intAElement = bodyElement.addChildElement(listaName);
            intAElement.addTextNode(valor1);


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
