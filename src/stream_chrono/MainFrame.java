/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_chrono;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Polack
 */
public class MainFrame extends JFrame{
    
    private MainPanel p = new MainPanel();
    
    
    public MainFrame(){
        
        this.getContentPane().add(p);
        //this.setLocation(/*706*/ 1722, 1045);
        this.setSize(500,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBackground(new Color(0, 0, 0, 128));
        //this.setLocationRelativeTo(null);
        this.setTitle("Chrono Setup");
        //this.setBackground(Color.BLUE);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    public MainPanel getP() {
        return p;
    }

    
    
    
    
    
    
}
