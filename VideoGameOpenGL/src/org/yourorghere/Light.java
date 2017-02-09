
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
public class Light {

    private float[] specular, diffuse, ambiental, pos;
    float x, y, z;
    boolean puntual;
    int id;
    GL gl;

    public Light(GL gl,float x, float y, float z, float[] ambiental, float[] diffuse, float[] specular, boolean puntual, int id) {
        this.specular = specular;
        this.diffuse = diffuse;
        this.ambiental = ambiental;
        pos = new float[4];
        this.x = x;
        this.y = y;
        this.z = z;
        this.puntual = puntual;
        this.id = id;
        this.gl = gl;
    }

    public void activate() {
        if (puntual) {
            pos[0] = x;
            pos[1] = y;
            pos[2] = z;
            pos[3] = 1;
        } else {
            pos[0] = x;
            pos[1] = y;
            pos[2] = z;
            pos[3] = 0;
        }
        gl.glLightfv(id, GL.GL_SPECULAR, specular, 0);
        gl.glLightfv(id, GL.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(id, GL.GL_AMBIENT, ambiental, 0);
        gl.glLightfv(id, GL.GL_POSITION, pos, 0);
    }
    public void setAmbient(float[] ambient){
        this.ambiental=ambient;
        
    }

   
}
