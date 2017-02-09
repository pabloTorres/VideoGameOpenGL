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
public class Escena {

    GL gl;
    Suelo suelo1;
    TorreControl ed1;
    Carcel c1;
    Celda celda1, celda2;
    Laberinto lab;

    public Escena(GL gl) {
        this.gl = gl;
        suelo1 = new Suelo(gl);
        ed1 = new TorreControl(gl);
        c1 = new Carcel(gl);
        celda1 = new Celda(gl);
        celda2 = new Celda(gl);
        lab = new Laberinto(gl);

    }

    public void drawEsc() {
        gl.glPushMatrix();
        gl.glTranslatef(10, 0, 50);
        gl.glScalef(2, 1, 3);
        suelo1.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
        ed1.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(70, 0, 0);
        ed1.draw();
        gl.glPopMatrix();
//carcel exterior
        gl.glPushMatrix();
        gl.glTranslatef(0, 9, 0);
        c1.draw();
        gl.glPopMatrix();

        //celdas
        gl.glPushMatrix();
        gl.glTranslatef(-40, 5, -260);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(2, 2, 2);
        celda1.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-40, 5, -300);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(2, 2, 2);
        celda2.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(105, 5, -260);
        gl.glRotatef(-90, 0, 1, 0);
        gl.glScalef(2, 2, 2);
        celda1.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(105, 5, -300);
        gl.glRotatef(-90, 0, 1, 0);
        gl.glScalef(2, 2, 2);
        celda1.draw();
        gl.glPopMatrix();

        gl.glPushMatrix();
lab.draw();
        
        gl.glPopMatrix();

    }

}
