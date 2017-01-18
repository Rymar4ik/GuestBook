package com.softgroup.servlet;

import com.softgroup.util.SQLConstantsQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class MainServlet extends HttpServlet {
    //При первой загрузке класса будет создана БД и Таблица. Данные можно изменить в com.softgroup.util.SQLConstantsQuery
    static {
        try {
            createDB();
            createDBUserTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //метод для получения соеденения с БД
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
    //метод для создания Базы Данных
    private static void createDB() throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = getDBConnection();
            statement = connection.prepareStatement(SQLConstantsQuery.CREATE_DB);
            statement.executeUpdate();
            System.out.println("Database is created!");
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
    }
    //метод для создания таблицы
    private static void createDBUserTable() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getDBConnection();
            connection.setCatalog(SQLConstantsQuery.DB_NAME);
            statement = connection.prepareStatement(SQLConstantsQuery.CREATE_TABLE);
            statement.executeUpdate();
            System.out.println("Table is created!");
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
    }
    //метод для добавления записи полученной с формы в таблицу
    private static void addGuestInfo(HttpServletRequest req) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getDBConnection();
            connection.setCatalog(SQLConstantsQuery.DB_NAME);
            statement = connection.prepareStatement(SQLConstantsQuery.ADD_GUEST_INFO);

            statement.setString(1,req.getParameter(SQLConstantsQuery.NAME));
            statement.setString(2,req.getParameter(SQLConstantsQuery.SURNAME));
            statement.setString(3,req.getParameter(SQLConstantsQuery.DATE));
            statement.setString(4,req.getParameter(SQLConstantsQuery.NUMBER));
            statement.setString(5,req.getParameter(SQLConstantsQuery.EMAIL));
            statement.setString(6,req.getParameter(SQLConstantsQuery.COUNTRY));
            statement.setString(7,req.getParameter(SQLConstantsQuery.REGION));

            int i = statement.executeUpdate();

            System.out.println("Information added successful!");
            System.out.println("DEBUG MESSAGE:" + i);

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

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            addGuestInfo(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.html").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
