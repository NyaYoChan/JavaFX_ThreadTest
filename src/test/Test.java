/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author user
 */
public class Test extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        Update Update = new Update(controller);
        Update.start();
        
        stage.setOnCloseRequest((WindowEvent event)->{
            Update.close();
            System.out.println("close window");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
}
