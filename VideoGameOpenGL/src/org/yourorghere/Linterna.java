/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.nio.FloatBuffer;
import javax.media.opengl.GL;

/**
 *
 * @author LABCOM
 */
public class Linterna extends Light {

    float cutoff, exponent;
    float[] direccion;

    GL gl;

    public Linterna(GL gl,float x, float y, float z, float[] ambiental, float[] diffuse, float[] specular, boolean puntual, int id,float angulo, float exponent, float[] direccion) {
        super(gl, x, y, z, ambiental, diffuse, specular, puntual, id);
        this.gl = gl;
        this.cutoff = angulo;
        this.exponent = exponent;
        this.direccion = direccion;
    }

    public void setCutoff(float cutoff) {
        this.cutoff = cutoff;
    }

    public void setExponent(float exponent) {
        this.exponent = exponent;
    }

    public void setDireccion(float[] direccion) {
        this.direccion = direccion;
    }

    public void activateSpot() {
        super.activate();
        gl.glLightf(id, GL.GL_SPOT_CUTOFF, cutoff);
        gl.glLightfv(id, GL.GL_SPOT_DIRECTION, direccion, 0);
        gl.glLightf(id, GL.GL_SPOT_EXPONENT, exponent);
    }
}
