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
public class Carcel {

    GLUT glut;
    GL gl;
    Piramide p1;
    float inc = 0;
    float inc2=0;
    boolean giro = false;

    public Carcel(GL gl) {
        this.gl = gl;
        glut = new GLUT();
        p1 = new Piramide(gl);
    }

    public void draw() {

        gl.glPushMatrix();
        gl.glTranslatef(-25, 0, -45f);
        gl.glScalef(35, 10, 1);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(95, 0, -45f);
        gl.glScalef(35, 10, 1);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(129, 0, -168f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(120, 10, 1);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-60, 0, -168f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(120, 10, 1);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        dib();
//edificio dentro
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-16, 1, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(26, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(81, 1, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(26, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(32, 22, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(25, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-8, 22, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(10, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-32, 22, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(10, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(73, 22, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(10, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(97, 22, -215f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(10, 11, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();



//techo
        gl.glPushMatrix();
        Game.materiales.get("rojo1").activarMaterial();
        gl.glTranslatef(32, 32, -275f);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(73, 70, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();
//pared izq eddentro
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-42, 11, -280f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(65, 20, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();
//paredder edDentro
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(104, 11, -280f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(65, 20, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(30, 11, -345f);
        //gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(75, 20, 1f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

    }

    public void dib() {

        if (giro == false) {

            gl.glPushMatrix();
            Game.materiales.get("verde1").activarMaterial();
            gl.glTranslatef(22, 0, -45);
            // gl.glRotatef(inc, 0, 1, 0);
            gl.glScalef(11.7f, 10, 1);
            glut.glutSolidCube(2);
            gl.glPopMatrix();

            gl.glPushMatrix();
            Game.materiales.get("verde1").activarMaterial();
            gl.glTranslatef(47.5f, 0, -45);
            // gl.glRotatef(-inc, 0, 1, 0);
            gl.glScalef(11.7f, 10, 1);
            glut.glutSolidCube(2);
            gl.glPopMatrix();
        }
        
        //animación

        if (giro == true) {
            if (inc>-90) {
                inc = inc - 0.6f;
               inc2=inc2+0.1f;
            }
             
            gl.glPushMatrix();
            Game.materiales.get("verde1").activarMaterial();
            gl.glTranslatef(22-inc2, 0, -45+inc2);
            gl.glRotatef(inc, 0, 1, 0);
            gl.glScalef(11, 10, 1);
            glut.glutSolidCube(2);
            gl.glPopMatrix();

            gl.glPushMatrix();
            Game.materiales.get("verde1").activarMaterial();
            gl.glTranslatef(47.5f+inc2, 0, -45+inc2);
            gl.glRotatef(-inc, 0, 1, 0);
            gl.glScalef(11, 10, 1);
            glut.glutSolidCube(2);
            gl.glPopMatrix();
        }

    }

}
