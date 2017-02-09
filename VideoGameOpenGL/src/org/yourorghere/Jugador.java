/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author LABCOM
 */
public class Jugador extends Personaje {

    public Jugador(float x, float y, float z, float v, GL gl) {
        super(x, y, z, v, gl);
    }

    @Override
    public void draw() {
        if (alive == true) {

            gl.glPushMatrix();
            gl.glTranslatef(x, y, z - 1);
            // gl.glRotatef(-(float) Math.toDegrees(angley), 0, 1, 0);
            gl.glRotatef((float) -Math.toDegrees(angley), 0f, 1f, 0f);
            gl.glRotatef(90, 0, 1, 0);
            ying.drawPerson();
            gl.glPopMatrix();

        }
        super.draw();
    }

}
