/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    private int clickedTimes = 0;
    
    @FXML
    private void handleButtonAction(KeyEvent event) {
//        System.out.println("You clicked me!");
        clickedTimes++;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void renderScreen(){
        System.out.println(clickedTimes);
//        label.setText(String.valueOf(clickedTimes));
    }
}
