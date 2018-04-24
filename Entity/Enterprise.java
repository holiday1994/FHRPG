/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author huntw
 */
public class Enterprise {
    public String enterpriseName;
    public double upkeep;
    public double revenue;
    public double grossprofit;
    public int qty;
    
    public Enterprise(){
        this.enterpriseName = null;
        this.upkeep = 0;
        this.revenue = 0;
        this.grossprofit = 0;
        this.qty = 0;
    }
    
    public Enterprise(String name, double up, double rev, double gp, int qty){
        enterpriseName = name;
        upkeep = up;
        revenue = rev;
        grossprofit = gp;
        this.qty = qty;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public double getUpkeep() {
        return upkeep;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getGrossprofit() {
        return grossprofit;
    }

    public int getQty() {
        return qty;
    }
    
    

}
