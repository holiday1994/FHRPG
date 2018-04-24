/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhgamedatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author huntw
 */
public class Inserter {
    Connector conn = new Connector();
    Scanner in = new Scanner(System.in);
    String tableName = "";

 /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
//    public void insert(String rowId) {
//        String sql = "INSERT INTO " + tableName + " VALUES(?,?)";
// 
//        try (            
//            PreparedStatement pstmt = conn.conn.prepareStatement(sql)) {
//            pstmt.setString(1, name);
//            pstmt.setDouble(2, capacity);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
 
        Inserter app = new Inserter();
        app.input();
        // insert three new rows
//        app.insert("Raw Materials", 3000);
//        app.insert("Semifinished Goods", 4000);
//        app.insert("Finished Goods", 5000);
    }
 
    public void input() throws SQLException{
        System.out.println("Which table?");
        tableName = in.nextLine();
        Selector select = new Selector();
        ResultSetMetaData rsmd = select.selectAll(tableName);  
        
        for(int x = 1; x <= rsmd.getColumnCount(); x++){
        System.out.println("Enter " + rsmd.getColumnName(x) + " This colum has a type of " + rsmd.getColumnTypeName(x));
        }
        }      
    } 
    
    

