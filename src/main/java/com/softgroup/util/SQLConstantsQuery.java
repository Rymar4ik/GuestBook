package com.softgroup.util;

//Класс создан для более удобной работы с БД используя SQL Запросы
public class SQLConstantsQuery {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306?autoReconnect=true&useSSL=false";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";

    public static final String DB_NAME = "guestbook";
    public static final String TABLE_NAME = "guestdata";

    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String DATE = "date";
    public static final String NUMBER = "number";
    public static final String EMAIL = "email";
    public static final String COUNTRY = "country";
    public static final String REGION = "region";

    public static final String CREATE_DB = "CREATE DATABASE " + DB_NAME;
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "(guest_id INTEGER NOT NULL AUTO_INCREMENT, "
            + "name VARCHAR(100) NOT NULL, "
            + "surname VARCHAR(100) NOT NULL, "
            + "birthday VARCHAR(100) NOT NULL, "
            + "number VARCHAR(100) NOT NULL, "
            + "email VARCHAR(100) NOT NULL, "
            + "country VARCHAR(100) NOT NULL, "
            + "region VARCHAR(100) NOT NULL, "
            + "PRIMARY KEY (guest_id) "
            + ") ENGINE=InnoDB";



    public static final String ADD_GUEST_INFO = "INSERT INTO " + TABLE_NAME +
            "(name, surname, birthday, number, email, country, region) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String GET_GUEST_DATA = "SELECT * FROM " + TABLE_NAME;
}
