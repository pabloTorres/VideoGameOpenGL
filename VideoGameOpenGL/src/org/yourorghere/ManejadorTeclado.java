/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Principal;

/**
 *
 * @author Pablo
 */
public class ManejadorTeclado implements KeyListener {

    Personaje movil;
    Game principal;

    public ManejadorTeclado(Personaje p, Game p1) {
        this.movil = p;

        principal = p1;

    }

    public void keyTyped(KeyEvent ke) {

        //To change body of generated methods, choose Tools | Templates.
        if (ke.getKeyChar() == 's') {
            this.movil.retroceder();

        }
        if (ke.getKeyChar() == 'a') {
            this.movil.izq();

        }
        if (ke.getKeyChar() == 'd') {
            this.movil.der();

        }
        if (ke.getKeyChar() == 'e') {
            this.movil.up();

        }
        if (ke.getKeyChar() == 'q') {
            this.movil.down();

        }

        if (ke.getKeyChar() == '4') {

            principal.auxCam = 4;
        }

        if (ke.getKeyChar() == '1') {

            principal.auxCam = 1;
        }

        if (ke.getKeyChar() == '2') {

            principal.auxCam = 2;
        }
        if (ke.getKeyChar() == '3') {

            principal.auxCam = 3;
        }

       if (ke.getKeyChar() == 'w') {
            this.movil.avanzar();

        }
             if (ke.getKeyChar() == 'b') {
            this.movil.disparar();
        }




    }

    public void keyPressed(KeyEvent ke) {

  
  
    }

    public void keyReleased(KeyEvent ke) {

    }

}
