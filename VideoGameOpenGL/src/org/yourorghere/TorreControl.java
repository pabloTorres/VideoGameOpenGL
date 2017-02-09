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
public class TorreControl {

    GLUT glut;
    GL gl;
    Piramide p1;

    public TorreControl(GL gl) {
        this.gl = gl;
        glut = new GLUT();
p1 = new Piramide(gl);
    }

    public void draw() {
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glScalef(4, 11, 4);
        gl.glTranslatef(0, 1, -11.45f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glScalef(9.2f, 0.7f, 10f);
        gl.glTranslatef(0, 32, -4.6f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glScalef(9.2f, 0.7f, 10f);
        gl.glTranslatef(0, 46, -4.6f);
        glut.glutSolidCube(2);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(0, 33, -46.3f);
        gl.glScalef(8.8f, .7f, 9f);
       // gl.glTranslatef(0, 46, -4.6f);
       // glut.glutSolidTetrahedron();
        p1.Draw();
        gl.glPopMatrix();

        //columnas 
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-6.7f, 27f, -38.2f);
        gl.glScalef(2f, 9.2f, 2f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(6.7f, 27f, -38.2f);
        gl.glScalef(2f, 9.2f, 2f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-6.7f, 27f, -54.5f);
        gl.glScalef(2f, 9.2f, 2f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(6.7f, 27f, -54.5f);
        gl.glScalef(2f, 9.2f, 2f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        //techo
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(0f, 24f, -54.5f);
        gl.glScalef(11.5f, 3.5f, 1.4f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();
        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(0f, 24f, -38.5f);
        gl.glScalef(11.5f, 3.5f, 1.4f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(6.6f, 24f, -45.5f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(15f, 3.5f, 1.4f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

    }

}
