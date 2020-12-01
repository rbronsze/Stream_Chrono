/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_chrono;

/**
 *
 * @author Polack
 */
public class ChronoControler {
    
    private MainFrame f;
    private ChronoModel m;
    
    public ChronoControler(MainFrame f){
        
        this.f = f;
        
    }

    public void setM(ChronoModel m) {
        this.m = m;
    }
    
    public void controlSet(){
        
        if(!m.isRunning()){
        
            int hour = 1;
            int minute = 0;
            int second = 0;

            if(f.getP().getHour().getDocument().getLength() != 0)
                hour = controlHour(f.getP().getHour().getText());

            if(f.getP().getMinute().getDocument().getLength() != 0)
                minute = controlInt(f.getP().getMinute().getText());

            if(f.getP().getSecond().getDocument().getLength() != 0)
                second = controlInt(f.getP().getSecond().getText());

            m.setHour(hour);
            m.setMinute(minute);
            m.setSecond(second);
            
            m.getChronoFrame().getP().setChrono();
            
            if(!m.isVisible()){
                m.getChronoFrame().getP().scrollWindow();
            }
        }

    }

    public void controlStart(){
        
        if(!m.isRunning()){
            
                if(m.isVisible()){
                    m.getChronoFrame().getP().startChrono();
                    m.setIsRunning(true);
                    f.getP().getStart().setText("Pause");
                }
                
        }else{
            if(m.isPaused()){
                m.setIsPaused(false);
                f.getP().getStart().setText("Pause");
                
            }else{
                m.setIsPaused(true);
                
            }
            
        }
        
    }
    
    public void controlStop(){
        
        m.setIsRunning(false);
        m.setIsPaused(false);
        f.getP().getStart().setText("Start");
        if(m.isVisible()){
            m.getChronoFrame().getP().scrollWindow();
        }
        
    }
    
    private int controlInt(String value){
        
        int nb = Integer.parseInt(value);
        
        if(nb < 0){
            nb = controlHour(value);
        }
            
        if(nb > 59){
            nb = 0;
        }
        
        return nb;
        
    }
    
    private int controlHour(String value){
        
        int nb = Integer.parseInt(value);
        
        if(nb < 0){
            return 0;
        }
        
        return Integer.parseInt(value);
        
    }
    
}
