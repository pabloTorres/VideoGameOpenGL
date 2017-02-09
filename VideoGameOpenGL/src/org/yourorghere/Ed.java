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
public class Ed {

    GLUT glut;
    GL gl;

    public Ed(GL gl) {
        this.gl = gl;
        glut = new GLUT();

    }

    public void draw() {
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glScalef(4,12,4);
        gl.glTranslatef(0, 1, -12);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

    }

}