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
public class Personaje implements Movil {

    GL gl;
    GLUT glut = new GLUT();
    Ying ying;
    Yang yang;
    Yang2 yang2;
    Ying2 ying2;
    float x, y, z, vel, anglex, angley;
    boolean alive = true;
    float incJump = 0;

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
        ying = new Ying(gl, glut);
        yang = new Yang(gl, glut);
        yang2 = new Yang2(gl, glut);
        ying2 = new Ying2(gl, glut);

    }

    public void avanzar() {

        this.z += (Math.sin(angley)) * vel;
        this.x += (Math.cos(angley)) * vel;

    }

    public void retroceder() {

        this.z -= (Math.sin(angley)) * vel;
        this.x -= (Math.cos(angley)) * vel;
    }

    public void izq() {

        // this.x -= this.vel;
        this.z -= (Math.sin(angley + (Math.PI / 2))) * vel;
        this.x -= (Math.cos(angley + (Math.PI / 2))) * vel;
    }

    public void der() {

        // this.x += this.vel;
        this.z += (Math.sin(angley + (Math.PI / 2))) * vel;
        this.x += (Math.cos(angley + (Math.PI / 2))) * vel;

    }

    public void down() {

        this.y -= this.vel;

    }

    public void up() {

        this.y += this.vel;

    }

    /*
     public void jump(){
     this.y += this.vel;
        
    
        
        
     }
     */
    public void draw() {

        for (Bala bala : balas) {//Cada una de las balas guardadas en el ArrayList se dibujarán
            bala.Draw();
        }

    }

    public void disparar() {//crea un nueva bala y la guarda en el arraylist
        if (alive) {
            balas.add(new Bala(x, y, z, 6, angley, anglex, gl));//Tiene las mimas coordenadas que el personaje, con una velocidad    
        }

    }

    public void actuar() {
        ArrayList<Bala> balastemp = new ArrayList();
        for (Bala bala : balas) {//Cada una de las balas guardadas en el ArrayList se dibujarán
            bala.actuar();

            if (bala.cont > 35) {//si supera el umbral la guartda en el nuevo array temp
                balastemp.add(bala);
            }
        }

        for (Bala bala : balastemp) {//borra todas las balas que están dentro de ella
            balas.remove(bala);
        }
    }

    public void getAngleY(Movil target) {
        angley = (float) Math.atan2(target.getZ() - z, target.getX() - x);

    }

    public void getAngleX(Movil target) {
        anglex = (float) Math.atan2(target.getX() - x, target.getY() - y);

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y1) {
        this.y = y1;
    }

    public float getZ() {
        return z;
    }

    public float getWidth() {
        return 2.4f;
    }

    public void die() {
        alive = false;
    }

}
