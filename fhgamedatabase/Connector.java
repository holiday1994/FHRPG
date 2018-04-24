/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhgamedatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author huntw
 */
public class Connector {
        public Connection conn = this.connect();

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\huntw\\OneDrive\\Documents\\SQLiteStudio\\Databases\\fhGame.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
