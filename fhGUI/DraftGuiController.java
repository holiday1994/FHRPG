/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhGUI;

import Entity.Enterprise;
import fhgamedatabase.Connector;
import fhgamedatabase.EnterpriseSelect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DraftGuiController {

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private TextField txtAgl;

    @FXML
    private Label lblAgl;

    @FXML
    private Label lblInt;

    @FXML
    private TextField txtInt;

    @FXML
    private Label lblStr;

    @FXML
    private TextField txtStr;

    @FXML
    private TableColumn<?, ?> enterpriseTable;

    @FXML
    private Label lblName;

    @FXML
    public TextField txtName;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private ImageView imageView;

    @FXML
    private Button rollStats;
    private Button btnAddImage;
    private Button btnShowEnterprises;
    @FXML
    private Button btnAddEnterprises;

    @FXML
    private TextArea txtAreaDesc;

    @FXML
    private TextArea txtAreaTable;

    @FXML
    private TableView<Enterprise> tableEnterprise;
    private TableColumn<Enterprise, String> colEnterprise = new TableColumn("Enterprise Name");;
    private TableColumn<Enterprise, Double> colUpkeep = new TableColumn("Upkeep");;
    private TableColumn<Enterprise, Double> colRevenue = new TableColumn("Revenue");
    private TableColumn<Enterprise, Double> colGP = new TableColumn("Gross Profit");
    private TableColumn<Enterprise, String> colQty = new TableColumn("Quantity");
        
    public String characterName = "MIKE";

    @FXML
    void initialize() {
    tableEnterprise.getColumns().addAll(colEnterprise, colUpkeep, colRevenue, colGP, colQty);

    }

    public void diceRoller() {

        ArrayList<Integer> list = new ArrayList();
        charactterSheet sheet = new charactterSheet();
        list = sheet.rollStats();
        txtStr.setText(list.get(0) + "");
        txtStr.setAlignment(Pos.CENTER);
        txtAgl.setText(list.get(1) + "");
        txtAgl.setAlignment(Pos.CENTER);
        txtInt.setText(list.get(2) + "");
        txtInt.setAlignment(Pos.CENTER);

    }

    public void addImage() {
        imageFinder image = new imageFinder();
        image.image(imageView);
    }
 
    public void showEnterprises() throws SQLException {
        assert tableEnterprise != null : "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
       
        EnterpriseSelect ent = new EnterpriseSelect();

//        colEnterprise = new TableColumn("Enterprise Name");
//        colUpkeep = new TableColumn("Upkeep");
//        colRevenue = new TableColumn("Revenue");
//        colGP = new TableColumn("Gross Profit");
//        colQty = new TableColumn("Quantity");

        tableEnterprise.setItems(ent.buildData(txtName.getText().toUpperCase()));
        
        colEnterprise.setCellValueFactory(
                new PropertyValueFactory<>("enterpriseName"));
        colUpkeep.setCellValueFactory(
                new PropertyValueFactory<>("upkeep"));
        colRevenue.setCellValueFactory(
                new PropertyValueFactory<>("revenue"));
        colGP.setCellValueFactory(
                new PropertyValueFactory<>("grossprofit"));
        colQty.setCellValueFactory(
                new PropertyValueFactory<>("qty"));

        Connector conn = new Connector();
    }
    
        public void addEnterprise() throws IOException{
            
        characterName = txtName.getText().toUpperCase();
        System.out.println(characterName);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enterprise.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                
    }
        
        public void onName(){

        }
       
        
        
        public String txtName(){
            return txtName.getText();
        }
    }

