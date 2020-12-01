/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrono_anim;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import stream_chrono.ChronoModel;

/**
 *
 * @author Polack
 */
public class ChronoPanel extends JPanel{
    
    private ChronoModel m;
    private Image chronoImg;
    private JLabel chronoLbl = new JLabel();
    private int v = 36;
    
    
    public ChronoPanel(ChronoModel m) throws IOException{
        
        this.m = m;
        
        chronoImg = ImageIO.read(new File("chrono.png"));
        this.chronoLbl.setForeground(Color.white);
        chronoLbl.setVisible(false);
        chronoLbl.setFont(new Font("Serif", Font.PLAIN, 22));

        this.add(chronoLbl);

        this.setBackground(Color.BLUE);
            
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(chronoImg, 0, v, this);
        Toolkit.getDefaultToolkit().sync();
    }

    public JLabel getChronoLbl() {
        return chronoLbl;
    }
    
    public void setChrono(){
        
            chronoLbl.setForeground(Color.white);
            chronoLbl.setText(addSpace(m.getHour()) + m.getHour() + ":" + addSpace(m.getMinute()) + m.getMinute() + ":" + addSpace(m.getSecond()) + m.getSecond());
            
    }
    
    public void scrollWindow(){
        
        Thread t = new ScrollThread();
        t.start();
        
    }
    
    public void startChrono(){
        
        Thread t = new CountdownThread();
        t.start();
        
    }
    
    private String addSpace(int nb){
            
        if(nb < 10)
            return "0";

        return "";

    }
    
    private class CountdownThread extends Thread{
        
        public void run(){
            
            while((m.getHour() > 0 || m.getMinute() > 0 || m.getSecond() > 0) && m.isRunning()){
                
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CountdownThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(m.isPaused()){
                    if(chronoLbl.getForeground() == Color.red)
                        chronoLbl.setForeground(Color.white);
                    else
                        chronoLbl.setForeground(Color.red);
                }else{
                    chronoLbl.setForeground(Color.white);
                    m.setSecond(checkDown(m.getSecond()));
                    if(checkEndOfCycle(m.getSecond())){
                        m.setMinute(checkDown(m.getMinute()));
                        if(checkEndOfCycle(m.getMinute())){
                            m.setHour(checkDown(m.getHour()));
                        }
                    }
                        
                    chronoLbl.setText(addSpace(m.getHour()) + m.getHour() + ":" + addSpace(m.getMinute()) + m.getMinute() + ":" + addSpace(m.getSecond()) + m.getSecond());
                    
                }
                
            }
            
            chronoLbl.setForeground(Color.red);
            m.setIsRunning(false);
            
        }
        
        private boolean checkEndOfCycle(int nb){
            
            if(nb == 59)
                return true;
            
            return false;
            
        }
        
        private int checkDown(int nb){
            
            if(nb == 0){
                return 59;
            }
            else{
                return nb - 1;
            }
            
        }
        
    }
    
    private class ScrollThread extends Thread{
        
        public void run(){
        
            if(m.isVisible()){
                chronoLbl.setVisible(false);
                scrollDown();
                m.setIsVisible(false);
            }
            else{
                scrollUp();
                chronoLbl.setVisible(true);
                m.setIsVisible(true);
            }
                
        }
        
        private void scrollUp(){
        
        while(v > 0){
                try {
                    sleep(16);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ScrollThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                v--;

            }

        }

        private void scrollDown(){

            while(v <= 35){
                try {
                    sleep(16);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ScrollThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                v++;
            }
        }
        
        
        
    }
    
    
}

    
