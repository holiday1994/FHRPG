package fhGUI;

import fhgamedatabase.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EnterpriseController {

    @FXML
    private TextField txtEnterpriseName;

    @FXML
    private TextField txtUpkeep;

    @FXML
    private TextField txtRevenue;
    @FXML
    private TextField txtQuantity;

    @FXML
    private Button btnCreateEnterprise;
    

    @FXML
    private TextField txtOwnedBy;
    
    public DraftGuiController mainGui = new DraftGuiController();

    
    @FXML
    void initialize() {
        txtOwnedBy.setText(mainGui.txtName());
    }

    @FXML
    void createEnterprise(ActionEvent event) throws SQLException {
        int gp = Integer.parseInt(txtRevenue.getText()) - Integer.parseInt(txtUpkeep.getText());
        Connector conn = new Connector();
        String id = "";
        

        System.out.println("IM HERE " + mainGui.txtName.getText());        
        ResultSet xSet = conn.conn.createStatement().executeQuery("Select * from Enterprises");
        
        ResultSet rs2 = conn.conn.createStatement().executeQuery("Select * from Character where UPPER(CharacterName = " + mainGui.characterName + ")" );

        int x = 0;
        while(rs2.next()){
            id = rs2.getString("characterID");
        }
        
        while(xSet.next()){
            x++;
        }

        String sqlQuery = "INSERT INTO Enterprises VALUES (" + x + ",'" + mainGui.txtName + "',";
        sqlQuery += txtUpkeep.getText() + ",";
        sqlQuery += txtRevenue.getText() + ")";
        
        String sqlQuery2 = "INSERT INTO OWNS VALUES (" + id;

        System.out.println(sqlQuery + "\n" + sqlQuery2 + "\n" + mainGui.txtName);
        
//        ResultSet rs = conn.conn.createStatement().executeQuery(sqlQuery);


        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

}
