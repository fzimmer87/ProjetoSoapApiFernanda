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
    ArrayList<NumberToWorld> lista = new ArrayList<>();
    ArrayList<NumberToDolar> lista2 = new ArrayList<>();
    ArrayList<Calculator> lista3 = new ArrayList<>();
    ArrayList<Multiplicacao> lista6 = new ArrayList<>();
    ArrayList<Subtracao> lista7 = new ArrayList<>();
    ArrayList<MoedaPais> lista8 = new ArrayList<>();
    ArrayList<TelefonePais> lista9 = new ArrayList<>();
    ArrayList<Countries> lista4 = new ArrayList<>();
    ArrayList<CelsiusFahrenheit> lista5 = new ArrayList<>();
    public ArrayList<NumberToWorld> pesquisarDadosUsuarios() {

        String sql = "SELECT * FROM numbertoword";
        conn = ConexaoSQL.getConexao();

        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                NumberToWorld numberToWord = new NumberToWorld();
                numberToWord.setNum(resultado.getString("valor"));
                numberToWord.setNumextenso(resultado.getString("numextenso"));
                lista.add(numberToWord);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }
  
    public List<NumberToDolar> pesquisaSQLNumberToDolar() {

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
    public List<Multiplicacao> pesquisaMultiplique(){
        String sql = "SELECT * FROM calculatormultiplica";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Multiplicacao calculator = new Multiplicacao();
                calculator.setValor1Multiplica(resultado.getString("valor1"));
                calculator.setValor2Multiplica(resultado.getString("valor2"));
                calculator.setResultadoMultiplica(resultado.getString("resultado"));
                lista6.add(calculator);
            }
        } catch (SQLException ex) {
        }
        return lista6;
    }
    public List<Subtracao> pesquisaSubtrai(){
        String sql = "SELECT * FROM calculatorsubtrai";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                Subtracao calculator = new Subtracao();
                calculator.setValor1Subtrai(resultado.getString("valor1"));
                calculator.setValor2Subtrai(resultado.getString("valor2"));
                calculator.setResultadoSubtrai(resultado.getString("resultado"));
                lista7.add(calculator);
            }
        } catch (SQLException ex) {
        }
        return lista7;
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
    public List<MoedaPais> pesquisaMoedaPais(){
        String sql = "SELECT * FROM moedapais";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                MoedaPais countries = new MoedaPais();
                countries.setSiglaPais(resultado.getString("pais"));
                countries.setMoedaPais(resultado.getString("moeda"));
                lista8.add(countries);
            }
        } catch (SQLException ex) {
        }
        return lista8;
    }
    public List<TelefonePais> pesquisaDDIPais(){
        String sql = "SELECT * FROM ddipais";
        conn = new ConexaoSQL().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            resultado = pstm.executeQuery(sql);

            while (resultado.next()) {
                TelefonePais countries = new TelefonePais();
                countries.setSiglaPais(resultado.getString("pais"));
                countries.setDdiPais(resultado.getString("ddi"));
                lista9.add(countries);
            }
        } catch (SQLException ex) {
        }
        return lista9;
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
