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
    Ed ed1;
    
    public Escena(GL gl){
        this.gl=gl;
    suelo1= new Suelo(gl);
    ed1= new Ed(gl);
    }
    
    
    public void drawEsc(){
        suelo1.draw();
        ed1.draw();
    }
    
}
