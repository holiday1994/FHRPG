/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhGUI;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author huntw
 */
public class charactterSheet  {

    Random rand = new Random();

    public ArrayList<Integer> getMax(ArrayList<Integer> list) {
        for (int x = 0; x < list.size() - 1; x++) {
            if (list.get(x) < list.get(x + 1)) {
                int temp = list.get(x + 1);
                list.set(x + 1, list.get(x));
                list.set(x, temp);
            }

        }
        return list;
    }

    public int getRoll(int x, int y) {
        int number = x + 1;
        while (number >= x) {
            number = rand.nextInt(x) + y;
        }
        return number;
    }

    public ArrayList<Integer> rollStats() {
        int num1 = 0, num2 = 0, num3 = 0;
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> result = new ArrayList();

        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                list.add(x, getRoll(20, 5));
            }
            list = getMax(list);
            if (i == 0) {
                num1 = list.get(0);
            }
            if (i == 1) {
                num2 = list.get(0);
            }
            if (i == 2) {
                num3 = list.get(0);
            }
        }
        result.add(num1);
        result.add(num2);
        result.add(num3);
        
        return result;
    }

        
}
