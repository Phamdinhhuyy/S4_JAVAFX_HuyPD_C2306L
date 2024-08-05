package com.c2306l.s4.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLStatement {
    private static String url = "jdbc:mysql://localhost:3306/s4";
    private static int port = 3306;
    private static String user = "root";
    private static String password = "huy1312@";
    private static Connection conn;
    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;

    }
    public static void closeConnection(){
        try{
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
