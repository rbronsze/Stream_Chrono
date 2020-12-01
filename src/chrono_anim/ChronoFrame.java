/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrono_anim;

import java.awt.Color;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import stream_chrono.ChronoModel;

/**
 *
 * @author Polack
 */
public class ChronoFrame extends JFrame{
    
    private ChronoPanel p;
    
    public ChronoFrame(ChronoModel m) throws IOException{
        
        p = new ChronoPanel(m);
        setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.getContentPane().add(p);
        this.setLocation(/*706*/ 1722, 1045);
        this.setSize(198,35);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //this.setBackground(new Color(0, 0, 0, 128));
        //this.setLocationRelativeTo(null);
        this.setTitle("Chrono");
        this.setBackground(Color.BLUE);
        this.setResizable(false);
        this.setVisible(true);
        
        RepaintThread t = new RepaintThread(this);
        t.start();
        
    }

    public ChronoPanel getP() {
        return p;
    }
    
    private class RepaintThread extends Thread{

        private ChronoFrame f;

        public RepaintThread(ChronoFrame f){

            this.f = f;

        }

        public void run(){

            while(true){

                try {
                    sleep(16);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChronoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                f.repaint();
                f.revalidate();

            }

        }
    }
    
}
