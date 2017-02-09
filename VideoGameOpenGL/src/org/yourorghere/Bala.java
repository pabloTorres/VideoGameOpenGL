/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;

/**
 *
 * @author fing.labcom
 */
public class Bala {
     float x,y,z, vel, anglex, angley;
    GL gl;
    Cubo cuerpo;
    int cont=0;
    
    
    public Bala(float x, float y, float z, float v, float angley, float anglex, GL gl ){
        this.x=x;
        this.y=y;
        this.z=z;
        this.vel=v;
        this.anglex=anglex;
        this.angley=angley;
        
        this.gl=gl;

        cuerpo= new Cubo(gl);
      
    }
    //Metodo que mueve al personaje
    public void avanzar(){
        this.z+=sin(angley)*this.vel;
        this.x+=cos(angley)*this.vel;
       
        this.y+= cos(anglex)*(this.vel/2);
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
    
    public void actuar(){//Que tiene que hacer cada vala cada instante
       avanzar(); 
       cont++;
       
    }
    
    
    
    public void Draw(){
        
//        gl.glColor3f(1,0,0);
        gl.glPushMatrix();
           gl.glTranslatef(x,y,z);
           gl.glScalef(0.3f,0.3f,0.3f);     
           cuerpo.draw();
        gl.glPopMatrix();
        
     }
}
