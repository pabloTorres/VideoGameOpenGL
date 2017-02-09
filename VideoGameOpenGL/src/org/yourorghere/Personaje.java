/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author Pablo
 */
public class Personaje {

    GL gl;
    GLUT glut = new GLUT();
    Jugador j;
    float x, y, z, vel, anglex, angley;

    Game principal;
    ArrayList<Bala> balas = new ArrayList();

    Personaje(float x, float y, float z, float v, GL gl) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vel = v;
        this.anglex = 0;
        this.angley = 0;
        this.gl = gl;

        principal = new Game();
        j = new Jugador(gl, glut);

    }

    public void avanzar() {

        /*if (principal.auxCam==4) {
         this.z += this.vel;
            
         }
         else   {
         */
        this.z += Math.sin(angley);
        this.x += Math.cos(angley);

    }

    public void retroceder() {

        this.z -= Math.sin(angley);
        this.x -= Math.cos(angley);

    }

    public void izq() {

        // this.x -= this.vel;
        this.z -= Math.sin(angley + (Math.PI / 2));
        this.x -= Math.cos(angley + (Math.PI / 2));
    }

    public void der() {

        // this.x += this.vel;
        this.z += Math.sin(angley + (Math.PI / 2));
        this.x += Math.cos(angley + (Math.PI / 2));

    }

    public void down() {

        this.y -= this.vel;

    }

    public void up() {

        this.y += this.vel;

    }

    public void draw() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        // gl.glRotatef(-(float) Math.toDegrees(angley), 0, 1, 0);
        gl.glRotatef((float) -Math.toDegrees(angley), 0f, 1f, 0f);
        gl.glRotatef(90, 0, 1, 0);
        j.drawPerson();
        gl.glPopMatrix();

        for (Bala bala : balas) {//Cada una de las balas guardadas en el ArrayList se dibujarán
            bala.Draw();
        }

    }

    public void disparar() {//crea un nueva bala y la guarda en el arraylist
        balas.add(new Bala(x, y, z, 3, angley, anglex, gl));//Tiene las mimas coordenadas que el personaje, con una velocidad 
    }

    public void actuar() {
        ArrayList<Bala> balastemp = new ArrayList();
        for (Bala bala : balas) {//Cada una de las balas guardadas en el ArrayList se dibujarán
            bala.actuar();

            if (bala.cont > 25) {//si supera el umbral la guartda en el nuevo array temp
                balastemp.add(bala);
            }
        }

        for (Bala bala : balastemp) {//borra todas las balas que están dentro de ella
            balas.remove(bala);
        }
    }

}
