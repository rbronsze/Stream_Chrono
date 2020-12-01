/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_chrono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Polack
 */
public class MainPanel extends JPanel{
    
    private static ChronoControler c;
    
    private JLabel h = new JLabel("H: ");
    private JLabel m = new JLabel("M: ");
    private JLabel s = new JLabel("S: ");
    
    private JTextField hour = new JTextField("1");
    private JTextField minute = new JTextField("0");
    private JTextField second = new JTextField("0");
    
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    private JButton set = new JButton("Set");
    
    public MainPanel(){
        
        hour.setDocument(new JTextIntLimited());
        hour.setHorizontalAlignment(SwingConstants.CENTER);
        
        minute.setDocument(new JTextIntLimited());
        minute.setHorizontalAlignment(SwingConstants.CENTER);
        second.setDocument(new JTextIntLimited());
        second.setHorizontalAlignment(SwingConstants.CENTER);
        
        hour.setText("1");
        minute.setText("0");
        second.setText("0");
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(h)
                .addComponent(hour)
                .addComponent(m)
                .addComponent(minute)
                .addComponent(s)
                .addComponent(second)
                .addComponent(set)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(start)
                        .addComponent(stop))
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(h)
                        .addComponent(hour)
                        .addComponent(m)
                        .addComponent(minute)
                        .addComponent(s)
                        .addComponent(second)
                        .addComponent(set))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(start)
                        .addComponent(stop))
        );
        
        this.set.addActionListener(new SetButtonListener());
        this.start.addActionListener(new StartButtonListener());
        this.stop.addActionListener(new StopButtonListener());
        
    }

    public JButton getStart() {
        return start;
    }

    public JButton getStop() {
        return stop;
    }

    public JButton getSet() {
        return set;
    }

    public JTextField getHour() {
        return hour;
    }

    public JTextField getMinute() {
        return minute;
    }

    public JTextField getSecond() {
        return second;
    }
    

    public void setHour(int hour) {
        this.hour.setText(Integer.toString(hour));
    }

    public void setMinute(int minute) {
        this.minute .setText(Integer.toString(minute));
    }

    public void setSecond(int second) {
        this.second .setText(Integer.toString(second));
    }

    public void setStart(String text) {
        this.start.setText(text);
    }
    
    public void setC(ChronoControler c) {
        this.c = c;
    }

    private class SetButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            c.controlSet();
        }

    }
    
    private class StartButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            c.controlStart();
        }

    }
    
    private class StopButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            c.controlStop();
        }

    }
       
}
