/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;

/**
 *
 * @author fing.labcom
 */
public class Bala implements Movil {

    float x, y, z, vel, anglex, angley;
    GL gl;
    //  Cubo cuerpo;
    int cont = 0;
    GLUT glut;
    Personaje p;

    public Bala(float x, float y, float z, float v, GL gl, Personaje p1) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vel = v;

        glut = new GLUT();
        this.gl = gl;
        p = p1;
        //  cuerpo= new Cubo(gl

    }

    public Bala(float x, float y, float z, float v, float angley, float anglex, GL gl) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vel = v;
        this.anglex = anglex;
        this.angley = angley;
        glut = new GLUT();
        this.gl = gl;

        //  cuerpo= new Cubo(gl
    }

    //Metodo que mueve al personaje
    public void avanzar() {
        this.z += sin(angley) * this.vel;
        this.x += cos(angley) * this.vel;

        this.y += cos(anglex) * (this.vel / 2);
    }

//    public void retroceder(){
//        this.z-=sin(angley)*this.vel;
//       this.x-=cos(angley)*this.vel; 
//    }
//    
//    public void izquierda(){
//     this.z+=sin(angley-(Math.PI/2))*this.vel;
//       this.x+=cos(angley-(Math.PI/2))*this.vel; 
//} 
//    
//    public void derecha(){
//      this.z+=sin(angley+(Math.PI/2))*this.vel;
//       this.x+=cos(angley+(Math.PI/2))*this.vel; 
//    }
//    
    public void actuar() {//Que tiene que hacer cada vala cada instante
        avanzar();
        cont++;

    }

    public void Draw() {

//        gl.glColor3f(1,0,0);
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glScalef(0.4f, 0.4f, 0.4f);
        //cuerpo.draw();
        // glut.glutSolidCube(1f
        Game.materiales.get("obsidiana").activarMaterial();
        glut.glutSolidSphere(1, 5, 5);

        gl.glPopMatrix();

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getWidth() {
        return 1f;
    }
}
