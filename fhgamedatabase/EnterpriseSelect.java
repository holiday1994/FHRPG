/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhgamedatabase;

import Entity.Enterprise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

/**
 *
 * @author huntw
 */
public class EnterpriseSelect {

//    public void Enterprise(TextArea tb) throws SQLException {
//        String sql = "select e.enterpriseName, e.upkeep, e.revenue from Enterprises e, Owns o, Character c where e.enterpriseid = o.enterpriseid and o.characterID = c.characterid";
//
//        Connector conn = new Connector();
//        Statement stmt = conn.conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//
//        ObservableList data = FXCollections.observableArrayList();
//        String output = "";
//
//        /**
//         * ******************************
//         * Data added to ObservableList *
//             *******************************
//         */
//        while (rs.next()) {
//            //Iterate Row
//            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                //Iterate Column
//                output += String.format("%-15s", rs.getString(i) + "\t");
//
//            }
//            output += "\n";
//        }
//
//        //FINALLY ADDED TO TableView
//        tb.appendText(output);
//    }

    private ObservableList<Enterprise> data;

    public ObservableList<Enterprise> buildData(String characterName) {
        data = FXCollections.observableArrayList();
        Connector conn = new Connector();
        try {
            Statement stmt = conn.conn.createStatement();
            String sql = "select e.enterpriseName, e.upkeep, e.revenue, o.quantity, (e.revenue-e.upkeep)*o.quantity as 'Gross Profit' from Enterprises e, Owns o, Character c where e.enterpriseid = o.enterpriseid and o.characterID = c.characterid and UPPER(c.characterName) = '" + characterName + "'";
            ResultSet rs = conn.conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Enterprise cm = new Enterprise();
                cm.enterpriseName = (rs.getString("enterpriseName"));
                cm.upkeep = rs.getInt("upkeep");
                cm.revenue = (rs.getInt("revenue"));
                cm.grossprofit = rs.getInt("Gross Profit");
                cm.qty = rs.getInt("quantity");
                data.add(cm);
            }
            
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
        return data;
    }

}
