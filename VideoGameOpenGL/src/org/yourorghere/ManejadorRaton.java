/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author LABCOM
 */
public class ManejadorRaton implements GLEventListener, MouseListener, MouseMotionListener {

    float oldx, oldy;
    Personaje personaje;

    public void init(GLAutoDrawable drawable, Personaje p) {
        drawable.addMouseMotionListener(this);
        drawable.addMouseListener(this);

        personaje = p;

        oldx = p.x;
        oldy = p.y;

    }

    public void display(GLAutoDrawable drawable) {
      
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
       
    }

    public void mouseClicked(MouseEvent me) {
     
    }

    public void mousePressed(MouseEvent me) {
        
        if (me.getButton() == MouseEvent.BUTTON1) {
        //    System.out.println("siiiiiiiii");
            personaje.disparar();

           // personaje.actuar();
        }
        
        
                
        if (me.getButton() == MouseEvent.BUTTON3) {
        //    System.out.println("siiiiiiiii");
//            Game32.en.disparar();
//             Game32.en1.disparar();
           // personaje.actuar();
        }
    }

    public void mouseReleased(MouseEvent me) {
       
    }

    public void mouseEntered(MouseEvent me) {
       
    }

    public void mouseExited(MouseEvent me) {
       
    }

    public void mouseDragged(MouseEvent me) {
        float x = me.getX();
        float y = me.getY();
       // System.out.println(personaje.anglex);

        personaje.angley += (x - oldx) / 160f;
        personaje.anglex += (y - oldy) / 160f;
//        personaje.anglex = personaje.anglex % 2*3.14f;
        oldx = x;
        oldy = y;
    }

    public void mouseMoved(MouseEvent e) {
        float x = e.getX();
        float y = e.getY();
       // System.out.println(personaje.anglex);

        personaje.angley += (x - oldx) / 160f;
        personaje.anglex += (y - oldy) / 160f;
//        personaje.anglex = personaje.anglex % 2*3.14f;
        oldx = x;
        oldy = y;
    }

    public void init(GLAutoDrawable drawable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
