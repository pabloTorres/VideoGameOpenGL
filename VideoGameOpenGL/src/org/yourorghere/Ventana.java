/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Pablo
 */
public class Ventana extends JFrame{
    private Dimension dim;
 
    public float heightV(){
      
//con esto obtienes en tamano en en x y y de tu monitor
        dim=super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);
        
        return dim.height;
    }
    
    
        public float widthV(){
      
//con esto obtienes en tamano en en x y y de tu monitor
        dim=super.getToolkit().getScreenSize();
        super.setSize(dim);
        super.setUndecorated(true);
        super.setVisible(true);
        
        return dim.width;
    }
    
}