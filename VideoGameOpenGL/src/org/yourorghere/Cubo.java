/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;

/**
 *
 * @author fing.labcom
 */
public class Cubo implements Movil {

    public GL gl;
    Material material;
    float x;
    float y;
    float z;
    float sx;
    float sy;
    float sz;

    public Cubo(GL gl) {
        this.gl = gl;
    }



    public Cubo(GL gl, int x, int y, int z) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Cubo(GL gl, Material m) {
        material = m;
        this.gl = gl;
    }

    public void draw() {
//gl.glTexEnvi(gl.GL_TEXTURE_ENV, gl.GL_TEXTURE_ENV_MODE, gl.GL_DECAL);
        gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_S, gl.GL_CLAMP);
        gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_T, gl.GL_CLAMP);

        //***********front*******
        gl.glBegin(GL.GL_QUADS);

        gl.glNormal3f(0, 0, 1);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(-1f, 1f, 1f);

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(1f, 1f, 1f);

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(1f, -1f, 1f);

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(-1f, -1f, 1f);
        gl.glEnd();

        //***********Back*******
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(0, 0, -1);
              gl.glTexCoord2f(0, 0);
        gl.glVertex3f(-1f, 1f, -1f);
              gl.glTexCoord2f(1, 0);
        gl.glVertex3f(1f, 1f, -1f);
              gl.glTexCoord2f(1, 1);
        gl.glVertex3f(1f, -1f, -1f);
        
              gl.glTexCoord2f(0, 1);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glEnd();

        //***********LEft*******
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(-1, 0, 0);
              gl.glTexCoord2f(0, 0);
        gl.glVertex3f(-1f, 1f, -1f);
              gl.glTexCoord2f(1, 0);
        gl.glVertex3f(-1f, 1f, 1f);
              gl.glTexCoord2f(1, 1);
        gl.glVertex3f(-1f, -1f, 1f);
              gl.glTexCoord2f(0, 1);
        gl.glVertex3f(-1f, -1f, -1f);
        gl.glEnd();

        //***********Right*******
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(1, 0, 0);
              gl.glTexCoord2f(0, 0);
        gl.glVertex3f(1f, 1f, -1f);
        
              gl.glTexCoord2f(1, 0);
        gl.glVertex3f(1f, 1f, 1f);
        
              gl.glTexCoord2f(1, 1);
        gl.glVertex3f(1f, -1f, 1f);
        
              gl.glTexCoord2f(0, 1);
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
        return 3;
    }

}
