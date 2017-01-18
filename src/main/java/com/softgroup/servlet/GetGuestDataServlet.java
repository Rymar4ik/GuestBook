package com.softgroup.servlet;

import com.softgroup.model.Row;
import com.softgroup.util.SQLConstantsQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetGuestDataServlet  extends HttpServlet{

    //Методы для удобного использования в сервлете

    private static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName(SQLConstantsQuery.DB_DRIVER);
            System.out.println("Driver was found!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(SQLConstantsQuery.DB_CONNECTION, SQLConstantsQuery.DB_USER, SQLConstantsQuery.DB_PASSWORD);
            System.out.println("Connection was received!");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    //метод для получения данных с таблицы, возвращает List обектов Row,
    // которые ялвяются обьектным представлением записей с БД
    private static List<Row> getGuestData() throws SQLException{

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Row> rows = new ArrayList<Row>();


        try {
            connection = getDBConnection();
            connection.setCatalog(SQLConstantsQuery.DB_NAME);
            statement  = connection.prepareStatement(SQLConstantsQuery.GET_GUEST_DATA);
            rs = statement.executeQuery();

//            Получаем ResultSet и превращаем каждую строку с БД в обьектное представление
//            для использования в JSP

            while (rs.next()){
                Row row = new Row();
                row.setName(rs.getString("name"));
                row.setSurname(rs.getString("surname"));
                row.setBirthday(rs.getString("birthday"));
                row.setNumber(rs.getString("number"));
                row.setEmail(rs.getString("email"));
                row.setCountry(rs.getString("country"));
                row.setRegion(rs.getString("region"));

                rows.add(row);
            }

            System.out.println("Data successful obtained from DB!");
            return rows;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return rows;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Передаем массив обектов row в jsp Для формаирования таблицы
        try {
            List<Row> rows = getGuestData();
            req.setAttribute("rows", rows);
            req.getRequestDispatcher("table.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
