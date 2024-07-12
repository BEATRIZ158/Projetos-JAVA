package com.br.fatecswing.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleConnection {

    private static Connection conexao = null;
    private static String servidor = "jdbc:postgresql://localhost:5432/bdaplcurso";
    private static String usuario = "postgres";
    private static String senha = "bia123";
    public static ResultSet resultset;

    static {
        try {
            conectar();
        } catch (Exception ex) {
            System.out.println("Erro ao conectar!");
            ex.printStackTrace();
        }
    }

    public SingleConnection() throws Exception {
        conectar();
    }

    public void excutaSQL(String sql) {
        try {
            Statement stm = conexao.createStatement(resultset.TYPE_SCROLL_INSENSITIVE, resultset.CONCUR_READ_ONLY);
            resultset = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro no statement: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void conectar() throws Exception {
        try {
            if (conexao == null) {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(servidor, usuario, senha);
                conexao.setAutoCommit(true);
                System.out.println("Conectado com sucesso!");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao conectar! \nErro: " + ex.getMessage());
        }
    }
    
    public static void desconetaBanco(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao encerra a conexao:"
                    + "Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

}
