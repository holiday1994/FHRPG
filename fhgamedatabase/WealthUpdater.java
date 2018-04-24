/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhgamedatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author huntw
 */
public class WealthUpdater
{
    Connector conn = new Connector();
 
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void update(int id, double wealth) {
        String sql = "UPDATE character SET wealth = ?"
                + "WHERE characterID = ?";
 
        try (
                PreparedStatement pstmt = conn.conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, wealth);
            pstmt.setInt(2, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WealthUpdater app = new WealthUpdater();
        // update the warehouse with id 3
//        app.update(0, 500);
    }
 
}