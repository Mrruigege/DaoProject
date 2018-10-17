package com.rui.Jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gc";
    private static final String USER = "root";
    private static final String PASSWORD = "kk123456";
    private Connection con = null;

    /**
     * 数据库连接类实例化的时候自动实现数据库的连接对象
     */
    public DatabaseConnection() {
        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到数据库连接
     * @return 返回连接对象
     */
    public Connection getConnection(){
        return this.con;
    }
    /**
     * 关闭数据库连接
     */
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
