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
public class Suelo {

    GLUT glut;
    GL gl;

    public Suelo(GL gl) {
        this.gl = gl;
        glut = new GLUT();

    }

    public void draw() {
        gl.glPushMatrix();
        Game.materiales.get("ruby").activarMaterial();
        gl.glScalef(60, .1f, 70);
        gl.glTranslatef(0, 0, -1);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

    }

}
