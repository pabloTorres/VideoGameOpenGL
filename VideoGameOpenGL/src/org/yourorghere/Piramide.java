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
public class Piramide {

    public GL gl;

    public Piramide(GL gl) {
        this.gl = gl;

    }

    public void Draw() {
        //botton

        gl.glBegin(gl.GL_QUADS);
        gl.glNormal3f(0, -1, 0);
        gl.glVertex3f(-1f, -1f, 1f);
        gl.glNormal3f(0, -1, 0);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glNormal3f(0, -1, 0);
        gl.glVertex3f(1f, -1f, -1f);
        gl.glNormal3f(0, -1, 0);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glEnd();

        //front
        gl.glBegin(gl.GL_POLYGON);
        gl.glNormal3f(0, 0, 1);
        gl.glVertex3f(0f, 8f, 0f);
        gl.glNormal3f(0, 0, 1);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glNormal3f(0, 0, 1);
        gl.glVertex3f(-1f, -1f, 1f);

        gl.glEnd();

        //right
        gl.glBegin(gl.GL_POLYGON);
        gl.glNormal3f(1, 0, 0);
        gl.glVertex3f(0f, 8f, 0f);
        gl.glNormal3f(1, 0, 0);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glNormal3f(1, 0, 0);
        gl.glVertex3f(1f, -1f, -1f);

        gl.glEnd();

        //back
        gl.glBegin(gl.GL_POLYGON);
        gl.glNormal3f(0, 0, -1);
        gl.glVertex3f(0f, 8f, 0f);
        gl.glNormal3f(0, 0, -1);
        gl.glVertex3f(1f, -1f, -1f);
        gl.glNormal3f(0, 0, -1);
        gl.glVertex3f(-1f, -1f, -1f);

        gl.glEnd();

        //left
        gl.glBegin(gl.GL_POLYGON);
        gl.glNormal3f(-1, 0, 0);
        gl.glVertex3f(0f, 8f, 0f);
        gl.glNormal3f(-1, 0, 0);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glNormal3f(-1, 0, 0);
        gl.glVertex3f(-1f, -1f, 1f);

        gl.glEnd();

    }

}
//casa, silla, mesa, arboles
