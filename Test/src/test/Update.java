/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import test.FXMLDocumentController;

public class Update extends Thread{
    public static final int FPS = 60;
    private boolean running = true;
    
    // problem
    FXMLDocumentController control = new FXMLDocumentController();
    
    public Update(){
        this.setDaemon(false);
        
    }
    
    public void run(){
        long timePerFrame = (long)(1.0 / FPS * Math.pow(10, 9));
        long lastFrame = System.nanoTime();
        long curFrame = System.nanoTime();
        int frame = 0;
        long lastCheck = System.currentTimeMillis();
        while(running){
            curFrame = System.nanoTime();
            if(curFrame - lastFrame >= timePerFrame){
                lastFrame = curFrame;
                control.renderScreen();
                frame++;
            }
            
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS:" + frame);
                frame = 0;
            }
        }
    }
    
    public void close(){
        running = false;
    }

}
