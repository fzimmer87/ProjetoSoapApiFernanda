package conexaoMySQL;

import DTO.*;
import DAO.ConexaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PesquisaEmBancoDeDados {
    PreparedStatement pstm;
    Connection conn;
    ResultSet resultado;
    ArrayList<NumberToWord> lista = new ArrayList<>();
    ArrayList<NumberToDolar> lista2 = new ArrayList<>();
    ArrayList<Calculator> lista3 = new ArrayList<>();
    ArrayList<Countries> lista4 = new ArrayList<>();
    ArrayList<CelsiusFahrenheit> lista5 = new ArrayList<>();
    public ArrayList<NumberToWord> pesquisarDadosUsuarios() {

        String sql = "SELECT * FROM numbertoword";
        conn = ConexaoSQL.getConexao();

        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                NumberToWord numberToWord = new NumberToWord();
                numberToWord.setNum(resultado.getString("valor"));
                numberToWord.setNumextenso(resultado.getString("numextenso"));
                lista.add(numberToWord);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }
    public List<NumberToDolar> pesquisaSQLNumberToDolar() throws InterruptedException {

        String sql = "SELECT * FROM NumberToDolar";
        conn = new ConexaoSQL().getConexao();

        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                NumberToDolar numberToDolar = new NumberToDolar();
                numberToDolar.setNum(resultado.getString("valor"));
                numberToDolar.setNumExtenso(resultado.getString("numextenso"));
                lista2.add(numberToDolar);
            }
        } catch (SQLException ex) {
        }
        return lista2;
    }
    public List<Calculator> pesquisaDivide(){
        String sql = "SELECT * FROM calculatordivide";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Calculator calculator = new Calculator();
                calculator.setValor1Divide(resultado.getString("valor1"));
                calculator.setValor2Divide(resultado.getString("valor2"));
                calculator.setResultadoDivide(resultado.getString("resultado"));
                lista3.add(calculator);
            }
        } catch (SQLException ex) {
        }
        return lista3;
    }
    public List<Calculator> pesquisaMultiplique(){
        String sql = "SELECT * FROM calculatormultiplica";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Calculator calculator = new Calculator();
                calculator.setValor1Multiplica(resultado.getString("valor1"));
                calculator.setValor2Multiplica(resultado.getString("valor2"));
                calculator.setResultadoMultiplica(resultado.getString("resultado"));
                lista3.add(calculator);
            }
        } catch (SQLException ex) {
        }
        return lista3;
    }
    public List<Calculator> pesquisaSubtrai(){
        String sql = "SELECT * FROM calculatorsubtrai";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Calculator calculator = new Calculator();
                calculator.setValor1Subtrai(resultado.getString("valor1"));
                calculator.setValor2Subtrai(resultado.getString("valor2"));
                calculator.setResultadoSubtrai(resultado.getString("resultado"));
                lista3.add(calculator);
            }
        } catch (SQLException ex) {
        }
        return lista3;
    }

    public List<Countries> pesquisaCapitalPais(){
        String sql = "SELECT * FROM capitalpais";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Countries countries = new Countries();
                countries.setSiglaPais(resultado.getString("pais"));
                countries.setCapitalPais(resultado.getString("capital"));
                lista4.add(countries);
            }
        } catch (SQLException ex) {
        }
        return lista4;
    }
    public List<Countries> pesquisaMoedaPais(){
        String sql = "SELECT * FROM moedapais";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Countries countries = new Countries();
                countries.setSiglaPais(resultado.getString("pais"));
                countries.setMoedaPais(resultado.getString("moeda"));
                lista4.add(countries);
            }
        } catch (SQLException ex) {
        }
        return lista4;
    }
    public List<Countries> pesquisaDDIPais(){
        String sql = "SELECT * FROM ddipais";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Countries countries = new Countries();
                countries.setSiglaPais(resultado.getString("pais"));
                countries.setDdiPais(resultado.getString("ddi"));
                lista4.add(countries);
            }
        } catch (SQLException ex) {
        }
        return lista4;
    }
    public List<CelsiusFahrenheit> pesquisaCelsiusFahrenheit(){
        String sql = "SELECT * FROM celsiusFahrenheit";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                CelsiusFahrenheit celsiusFahrenheit = new CelsiusFahrenheit();
                celsiusFahrenheit.setCelsius(resultado.getString("celsius"));
                celsiusFahrenheit.setFahrenheit(resultado.getString("fahrenheit"));
                lista5.add(celsiusFahrenheit);
            }
        } catch (SQLException ex) {
        }
        return lista5;
    }
}
