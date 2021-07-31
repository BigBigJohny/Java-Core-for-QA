package ru.geekbrains.lesson8;

import java.sql.*;

public class Repository {

    private static final String url = "jdbc:mysql://localhost:3306/weather";
    private static final String user = "root";
    private static final String password = "123456";

    private static Connection con;
    private static Statement stmt;
    private static int rs;
    private static ResultSet rs1;

    public static void saveBd(String city, String localDate, String weatherText, String temperature) {
        String query = "insert into tb_weather (city, localDate, weatherText, temperature) values (" + "\"" + city + "\"" +
                ", " + "\"" + localDate + "\"" + ", " + "\"" + weatherText + "\"" + ", " + "\"" + temperature + "\"" + ")";

        try {
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            rs = stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void selectAll() {
        String query = "select * from tb_weather";

        try {
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            rs1 = stmt.executeQuery(query);

            while (rs1.next()) {
                int id = rs1.getInt("id");
                String city = rs1.getString("city");
                String localDate = rs1.getString("localDate");
                String weatherText = rs1.getString("weatherText");
                double temperature = rs1.getDouble("temperature");
                System.out.println("id =  " + id);
                System.out.println("city = " + city);
                System.out.println("localDate = " + localDate);
                System.out.println("weatherText =  " + weatherText);
                System.out.println("temperature =  " + temperature);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                rs1.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
