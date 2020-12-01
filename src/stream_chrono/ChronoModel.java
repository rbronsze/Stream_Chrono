/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_chrono;

import chrono_anim.ChronoFrame;
import java.io.IOException;

/**
 *
 * @author Polack
 */
public class ChronoModel {
    
    private MainFrame f;
    private ChronoControler c; 
    private boolean isPaused, isVisible, isRunning;
    private int hour = 0, minute = 0, second = 0;
    private ChronoFrame chronoFrame;
    
    public ChronoModel(MainFrame f, ChronoControler c) throws IOException{
        
        this.f = f;
        this.c = c;
        
        isPaused = false;
        isVisible = false;
        isRunning = false;
        
        hour = 0;
        minute = 0;
        second = 0;
        
        chronoFrame = new ChronoFrame(this);
        
    }
    
    /////////////////
    //   Boolean   //
    /////////////////
    
    public boolean isPaused() {
        return isPaused;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isRunning() {
        return isRunning;
    }
    
    /////////////////
    //   Getters   //
    /////////////////
    
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public ChronoFrame getChronoFrame() {
        return chronoFrame;
    }

    public MainFrame getF() {
        return f;
    }

    public ChronoControler getC() {
        return c;
    }

    /////////////////
    //   Setters   //
    /////////////////
    
    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    
}
