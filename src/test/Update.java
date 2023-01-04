/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Update extends Thread{
    public static final int FPS = 60;
    private boolean running = true;
    private FXMLDocumentController controller;
    
    public Update(FXMLDocumentController controller){
        this.setDaemon(false);
        this.controller = controller;
    }
    
    public void run(){
        long timePerFrame = (long)(1.0 / FPS * Math.pow(10, 9));
        long lastFrame = System.nanoTime();
        long curFrame;
        int frame = 0;
        long lastCheck = System.currentTimeMillis();
        while(running){
            curFrame = System.nanoTime();
            if(curFrame - lastFrame >= timePerFrame){
                lastFrame = curFrame;
                controller.logicalHandle();
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
