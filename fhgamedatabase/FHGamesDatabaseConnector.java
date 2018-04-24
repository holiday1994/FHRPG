package fhgamedatabase;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class FHGamesDatabaseConnector {
 
    WealthUpdater app = new WealthUpdater();
    Connector conn = new Connector();
    /**
     * Connect to the test.db database
     * @return the Connection object
     */

 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        
        String sql = "select c.characterName, c.agility, c.strength, c.intelligence, c.wealth, c.characterID, "
                + "(sum(e.revenue-e.upkeep)) as Income, g.goodName, g.marketPrice "
                + "from character c, owns o, enterprises e, produces p, goods g, players ply "
                + "where ply.playerID=c.playerID and c.characterID=o.characterID and "
                + "o.enterpriseID=e.enterpriseID and e.enterpriseID=p.enterpriseID and p.goodsID=g.goodID";
        
        try (
             Statement stmt  = conn.conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            System.out.println("Character Name\tAgility\t\tStrength\tIntelligence\tIncome\t\tWealth\t");
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("characterName") +  "\t" + 
                                   rs.getDouble("Agility") + "\t\t" +
                                   rs.getDouble("Strength") + "\t\t" + rs.getDouble("intelligence") +
                                          "\t\t" + rs.getDouble("Income")
                                         + "\t\t" + (rs.getDouble("wealth") + rs.getDouble("Income"))
                                   );
                
                app.update(rs.getInt("characterID"), (rs.getDouble("wealth") + rs.getDouble("Income")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FHGamesDatabaseConnector app = new FHGamesDatabaseConnector();
        app.selectAll();
    }
 
}