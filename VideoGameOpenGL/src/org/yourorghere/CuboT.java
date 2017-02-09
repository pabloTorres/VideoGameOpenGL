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
public class CuboT implements Movil {

    float x;
    float y;
    float z;
    float sx;
    float sy;
    float sz;
    float rx;
    float ry;
    float rz;
    GL gl;
    Cubo c;

    CuboT() {

    }

    public CuboT(GL gl, int x, int y, int z, int sx, int sy, int sz) {

        this.gl = gl;

        c = new Cubo(gl);
        this.x = x;
        this.y = y;
        this.z = z;

        this.sx = sx;
        this.sy = sy;
        this.sz = sz;

    }

    public void draw() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glScalef(sx, sy, sz);
        c.draw();
        gl.glPopMatrix();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getWidth() {
        return 17;
    }

}
