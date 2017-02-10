/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author LABCOM
 */
public class Enemigo extends Personaje {

    Personaje p;

    public Enemigo(float x, float y, float z, float v, GL gl) {
        super(x, y, z, v, gl);
    }
    

    public void disparar(){
         if (alive) {
          balas.add(new Bala(x, y, z, 5, angley, anglex, gl));  
         }
    }

    @Override
    public void draw() {
      if (alive == true) {
            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            //gl.glRotatef(-(float) Math.toDegrees(angley), 0, 1, 0);
            gl.glRotatef((float) -Math.toDegrees(angley), 0f, 1f, 0f);
         gl.glRotatef(90, 0, 1, 0);
            yang.drawPerson();
            gl.glPopMatrix();
           
        }
 super.draw();
    }
    
    
    @Override
   public float getWidth() {
        return 4;
    }
    

}
