/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author Pablo
 */
public class Llave extends Personaje {

    boolean key = false;
    GLUT glut;

    public Llave(float x, float y, float z, float v, GL gl, GLUT glut) {
        super(x, y, z, v, gl);
        this.glut = glut;
    }

    public void drawKey() {
        if (key == false) {

            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            gl.glScalef(1, 3, 1);
            Game.materiales.get("cyan1").activarMaterial();
            glut.glutSolidCube(1);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            gl.glTranslatef(0, 3, 0);
            Game.materiales.get("cyan1").activarMaterial();
            gl.glScalef(0.6f, 0.6f, 0.6f);
            glut.glutSolidTorus(1, 2, 30, 30);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            gl.glTranslatef(1, 0, 0);
            gl.glScalef(1.5f, 0.5f, 0.5f);
            Game.materiales.get("cyan1").activarMaterial();
            glut.glutSolidCube(1);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            gl.glTranslatef(1, -1, 0);
            gl.glScalef(1.5f, 0.5f, 0.5f);
            Game.materiales.get("cyan1").activarMaterial();
            glut.glutSolidCube(1);
            gl.glPopMatrix();

        }

    }

}
