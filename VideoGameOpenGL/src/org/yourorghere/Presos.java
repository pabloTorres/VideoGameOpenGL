/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Pablo
 */
public class Presos extends Personaje {
    float posx=0;
    float posz=0;
public static boolean seguir=false;
    public Presos(float x, float y, float z, float v, GL gl) {
        super(x, y, z, v, gl);
    }

    @Override
    public void draw() {
        if (alive == true) {
            
            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            
            
            if (seguir) {
                posx=Game.person.x;
                posz=Game.person.z;
                
                
               gl.glTranslatef(Game.person.x, 0, Game.person.z-20);  
            }
           
            // gl.glRotatef(-(float) Math.toDegrees(angley), 0, 1, 0);
            gl.glRotatef((float) -Math.toDegrees(angley), 0f, 1f, 0f);
gl.glRotatef(90, 0, 1, 0);
            ying2.drawPerson();
            gl.glPopMatrix();

        }
        super.draw();
    }
    
    @Override
      public float getWidth() {
        return 6;
    
      }
}