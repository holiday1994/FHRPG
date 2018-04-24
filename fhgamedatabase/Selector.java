/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhgamedatabase;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TableView;

/**
 *
 * @author huntw
 */
public class Selector {
    Connector conn = new Connector();
    /**
     * Connect to the test.db database
     * @return the Connection object
     */

 
    
    /**
     * select all rows in the warehouses table
     */
    public ResultSetMetaData selectAll(TableView table) throws SQLException{
        
        ResultSetMetaData rsmd = null;
        String sql = "select e.enterpriseName, e.upkeep, e.revenue from Enterprises e, Owns o, Characters c where e.enterpriseid = o.enterpriseid and o.characterID = c.characterid";
        try (
             Statement stmt  = conn.conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             rsmd = rs.getMetaData();

            
            // loop through the result set
            while (rs.next()) {
                for(int x = 1; x <= rsmd.getColumnCount(); x++){
                System.out.print(rs.getString(x) +  "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rsmd;
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Selector app = new Selector();
    }
 
}

