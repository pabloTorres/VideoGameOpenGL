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
public class Ying {

    GL gl;
    GLUT glut;

    public Ying(GL gl, GLUT glut) {
        this.gl = gl;
        this.glut = glut;

    }

    public void drawPerson() {

//cabeza
        gl.glPushMatrix();
        Game.materiales.get("rojo2").activarMaterial();
        glut.glutSolidSphere(2, 50, 50);
        gl.glPopMatrix();
        /*
         gl.glPushMatrix();
         Game32.materiales.get("blanco1").activarMaterial();
         gl.glTranslatef(-.6f, 0, 1.5f);
         glut.glutSolidSphere(.7f, 50, 50);
         gl.glPopMatrix();

         gl.glPushMatrix();
         Game32.materiales.get("blanco1").activarMaterial();
         gl.glTranslatef(.6f, 0, 1.5f);
         glut.glutSolidSphere(.7f, 50, 50);
         gl.glPopMatrix();
         */

//cuello
        gl.glPushMatrix();
        Game.materiales.get("verde1").activarMaterial();
        gl.glTranslatef(0, 0, -20.4f);
        //  gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(1f, 1f, 1f);
        glut.glutSolidCylinder(.6, 4, 25, 25);
        gl.glPopMatrix();
        /*
        
        
        
        
         */
//cuerpo
        gl.glPushMatrix();
        gl.glTranslatef(0, -3.3f, 0);
        gl.glScalef(2.5f, 3f, 3f);
        // gl.glRotatef(90, 1, 0, 0);
        Game.materiales.get("negro").activarMaterial();
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, .6f, 1f);
        // gl.glRotatef(90, 1, 0, 0);
        gl.glRotatef((float) Math.toDegrees(Game.person.anglex)/3, 1f, 0f, 0f);
       //   gl.glRotatef((float) -Math.toDegrees(Game32.person.anglex), 0f, 1f, 0f);
          gl.glRotatef(-20, 1, 0, 0);
        gl.glScalef(1.3f, 1.3f, 1.5f);
        Game.materiales.get("verde1").activarMaterial();
        glut.glutSolidCylinder(.6, 4, 25, 25);
        gl.glPopMatrix();
        
        
        
        
                gl.glPushMatrix();
        gl.glTranslatef(0, 35, 60f);
        // gl.glRotatef(90, 1, 0, 0);
        gl.glTranslatef(0, -(float) Math.toDegrees(Game.person.anglex)/2.8f, 0f);
       //   gl.glRotatef((float) -Math.toDegrees(Game32.person.anglex), 0f, 1f, 0f);
          gl.glRotatef(-20, 1, 0, 0);
        gl.glScalef(.5f, .5f, .5f);
        Game.materiales.get("verde1").activarMaterial();
        glut.glutSolidTorus(.1 ,2, 10, 10);
        gl.glPopMatrix();
        
        /*       
        
         gl.glPushMatrix();
         gl.glTranslatef(-1.7f, -1.7f, .8f);
         gl.glRotatef(90, 1, 0, 0);
         gl.glScalef(1f, 1f, .7f);
         Game32.materiales.get("verde1").activarMaterial();
         glut.glutSolidCylinder(.6, 4, 25, 25);
         gl.glPopMatrix();
         */
    }

}
