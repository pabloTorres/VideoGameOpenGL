/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import static org.yourorghere.Game.person;

/**
 *
 * @author fing.labcom
 */
public class Metodos_Aux {

    public static boolean Colision(Movil b, Movil e) {
        return (Math.sqrt((Math.pow((b.getX() - e.getX()), 2)) + (Math.pow(b.getZ() - (e.getZ()), 2))) * 90) < (((b.getWidth() / 2) + (e.getWidth() / 2)) * 90);

    }

    public static float distance(Movil m1, Movil m2) {
        return (float) Math.sqrt((Math.pow((m1.getX() - m2.getX()), 2)) + (Math.pow((m1.getZ() - m2.getZ()), 2)));
    }

    public static void repeler(Movil m1, Movil m2) {

       // person.retroceder();

         if (m1.getZ() > m2.getZ()) {
          person.z += 0.6f;

         //person.retroceder();
         }

         if (m1.getZ() < m2.getZ()) {
        person.z -= 0.6f;
         }
         
        if (m1.getX() < m2.getX()) {
            person.x -= 0.6f;
        }

        if (m1.getX() > m2.getX()) {
            person.x += 0.6f;
        }

        if (ManejadorTeclado.keyStates['w']) {
            person.retroceder();
            person.z += 0.5f;
        }
        if (ManejadorTeclado.keyStates['s']) {
            person.avanzar();
            person.z -= 0.5f;
        }

        if (ManejadorTeclado.keyStates['d']) {
            person.izq();

        }

        if (ManejadorTeclado.keyStates['a']) {
            person.der();

        }

    }
    
    
    public static void seguir(Personaje enemigo1,Personaje person){
              if (enemigo1.getX() < person.getX()) {
         
                //  Enemigo2.seguir=true;
               enemigo1.x+=1;   
            }
            
            if (enemigo1.getX() > person.getX()) {
             
                //  Enemigo2.seguir=true;
                enemigo1.x-=1;
            }
            
            
                  if (enemigo1.getZ() < person.getZ()) {
                
                //  Enemigo2.seguir=true;
               enemigo1.z+=1;   
            }
            
            if (enemigo1.getZ() > person.getZ()) {
             
                //  Enemigo2.seguir=true;
                enemigo1.z-=1;
            }
    }
    

}
