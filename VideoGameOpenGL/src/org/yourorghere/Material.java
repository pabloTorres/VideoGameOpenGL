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
public class Material {
    GL gl;
    // uno porque es puntual
    float []ambient={0.5f,0.5f,0.5f,1};
    float []diffuse={0.5f,0.5f,0.5f,1};
    float []specular={0.1f,0.1f,0.1f,1};
    float emmisive=0;
    float shinesse;
    
    public Material(GL gl){
        this.gl=gl;
        this.shinesse=0.5f;
    }

    public void setAmbient(float[] a) {
        this.ambient = a;
    }

    public void setDiffuse(float[] d) {
        this.diffuse = d;
    }

    public void setSpecular(float[] sp) {
        this.specular = sp;
    }

    public void setShinesse(float sh) {
        this.shinesse = sh;
    }
    
      public void setEmisive(float em) {
        this.emmisive = em;
    }
    
    
       public void setMaterial(float[] a, float[] d, float[] s,float sh) {
        this.shinesse = sh;
        this.ambient=a;
        this.diffuse=d;
        this.specular=s;
        this.shinesse=sh;
    }
    
    public void activarMaterial(){
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, specular, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, shinesse);
        //gl.glMaterialf(GL.GL_FRONT, GL.GL_EMISSION,emmisive );
    }     
                
    
    
}

