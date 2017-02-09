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
public class Celda {

    GLUT glut;
    GL gl;
    //Piramide p1;

    public Celda(GL gl) {
        this.gl = gl;
        glut = new GLUT();
        // p1 = new Piramide(gl);
    }

    public void draw() {

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(0, 2f, 0);
        gl.glScalef(20, 11, .7f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(-10, 2f, 10);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(20, 11, .7f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(10, 2, 10);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(20, 11, .7f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("blanco1").activarMaterial();
        gl.glTranslatef(0, 7.3f, 10);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(20, 20, .5f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();
        //cama
        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-8f, -1f, 8);
        gl.glScalef(4, .3f, 10);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        //baño
        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glTranslatef(8f, -1f, 8);
        gl.glRotatef(90, 1, 0, 0);
        glut.glutSolidTorus(.4f, 1f, 30, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glTranslatef(9f, 0f, 8);
       // gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(.7f, 2.5f, 2f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();


        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glTranslatef(8f, -1f, 8);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(2, 2f, 2f);
        glut.glutSolidCylinder(.4f, 1f, 30, 30);
        gl.glPopMatrix();
        //barrotes
        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(0, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-2, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-4, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();
        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-6, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(2, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(4, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();
        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(6, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(8, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();
        gl.glPushMatrix();
        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-8, 7, 18);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1, 1, 1.5f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

        Game.materiales.get("obsidiana").activarMaterial();
        gl.glTranslatef(-10.3f, 2, 18);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(1, 1, 2.9f);
        // gl.glScalef(3, .3f, 10);
        glut.glutSolidCylinder(.2f, 7, 60, 30);
        gl.glPopMatrix();

    }

}
