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
 * @author LABCOM
 */
public class Yang {

    GL gl;
    GLUT glut;

    public Yang(GL gl, GLUT glut) {
        this.gl = gl;
        this.glut = glut;

    }

    public void drawPerson() {

//cabeza
        gl.glPushMatrix();
        gl.glTranslatef(0, 0.5f, 0);
        gl.glScalef(1f, 1f, 1f);
        Game.materiales.get("ruby").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.8f, 0, 2);
        gl.glScalef(.3f, .3f, .3f);
        Game.materiales.get("blanco1").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.9f, 0, 2.5f);
        gl.glScalef(.2f, .2f, .2f);
        Game.materiales.get("negro").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.8f, 0, 2);
        gl.glScalef(.3f, .3f, .3f);
        Game.materiales.get("blanco1").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();
        
        
            gl.glPushMatrix();
        gl.glTranslatef(0.9f, 0, 2.5f);
        gl.glScalef(.2f, .2f, .2f);
        Game.materiales.get("negro").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, -1f, 2);
        gl.glScalef(.3f, .1f, .3f);
        Game.materiales.get("negro").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();
//cuello
        gl.glPushMatrix();
        gl.glScalef(1f, .5f, 1f);
        gl.glRotatef(90, 1, 0, 0);
        gl.glTranslatef(0, 0, 2);
        Game.materiales.get("blanco1").activarMaterial();
        glut.glutSolidCylinder(.6, 4, 25, 25);
        gl.glPopMatrix();
//cuerpo
        gl.glPushMatrix();
        gl.glScalef(2.5f, 3f, 2.5f);
        // gl.glRotatef(90, 1, 0, 0);
        gl.glTranslatef(0, -1.2f, 0);
        Game.materiales.get("cyan1").activarMaterial();
        glut.glutSolidCube(1);
        gl.glPopMatrix();

    }

}
