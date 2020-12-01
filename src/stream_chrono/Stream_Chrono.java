/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_chrono;

import java.io.IOException;

/**
 *
 * @author Polack
 */
public class Stream_Chrono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MainFrame f = new MainFrame();
        ChronoControler c = new ChronoControler(f);
        ChronoModel m = new ChronoModel(f, c);
        f.getP().setC(c);
        c.setM(m);
    }
    
}
