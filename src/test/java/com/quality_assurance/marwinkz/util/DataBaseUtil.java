package com.quality_assurance.marwinkz.util;

import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static DataBaseUtil instance;

    private DataBaseUtil (){

    }

    public static DataBaseUtil getInstance() {
        if (instance == null) {
            instance = new DataBaseUtil();
        }
        return instance;
    }

    public void createConnection() {
        String dbUrl = "jdbc:postgresql://localhost:5432/marwin_test";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(query);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Map<String, Object>> getQueryResultMap(String query) {
        createConnection();
        List<Map<String, Object>> rowList = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rowList;
    }

}
