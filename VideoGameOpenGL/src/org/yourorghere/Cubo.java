/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author fing.labcom
 */
public class Cubo {

    public GL gl;
    Material material;

    public Cubo(GL gl) {
        this.gl = gl;
    }

    public Cubo(GL gl, int x, int y, int z) {
        this.gl = gl;
    }

    public Cubo(GL gl, Material m) {
        material = m;
        this.gl = gl;
    }

    public void draw() {

        //***********front*******
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(0, 0, 1);
        gl.glVertex3f(-1f, 1f, 1f);
        gl.glVertex3f(1f, 1f, 1f);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glVertex3f(-1f, -1f, 1f);
        gl.glEnd();

        //***********Back*******
        gl.glBegin(GL.GL_QUADS);
 gl.glNormal3f(0, 0, -1);
        gl.glVertex3f(-1f, 1f, -1f);
        gl.glVertex3f(1f, 1f, -1f);
        gl.glVertex3f(1f, -1f, -1f);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glEnd();

        //***********LEft*******
        gl.glBegin(GL.GL_QUADS);
 gl.glNormal3f(-1, 0, 0);
        gl.glVertex3f(-1f, 1f, -1f);
        gl.glVertex3f(-1f, 1f, 1f);
        gl.glVertex3f(-1f, -1f, 1f);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glEnd();

        //***********Right*******
        gl.glBegin(GL.GL_QUADS);
 gl.glNormal3f(1, 0, 0);
        gl.glVertex3f(1f, 1f, -1f);
        gl.glVertex3f(1f, 1f, 1f);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glVertex3f(1f, -1f, -1f);
        gl.glEnd();
        //***********top*******
        gl.glBegin(GL.GL_QUADS);
 gl.glNormal3f(0, 1, 0);
        gl.glVertex3f(-1f, 1f, -1f);
        gl.glVertex3f(1f, 1f, -1f);
        gl.glVertex3f(1f, 1f, 1f);
        gl.glVertex3f(-1f, 1f, 1f);
        gl.glEnd();

        //***********botton*******
        gl.glBegin(GL.GL_QUADS);
         gl.glNormal3f(0, -1, 0);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glVertex3f(1f, -1f, -1f);
        gl.glVertex3f(1f, -1f, 1f);
        gl.glVertex3f(-1f, -1f, 1f);
        gl.glEnd();

    }

}
