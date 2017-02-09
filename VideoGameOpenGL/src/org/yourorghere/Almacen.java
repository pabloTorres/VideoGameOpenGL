/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLException;

/**
 *
 * @author Pablo
 */
public class Almacen {
    
    /*
    Texturas:
    A single texture is worth than a thousand triangles
    
    textures is a picture that we map to the surface of a triangle or 
    
    
    
    */
    
    
    
    

    // public static HashMap<String, Material> mater = new HashMap<String, Material>();
    GL gl;

    public Almacen(GL gl1, HashMap<String, Material> mater, HashMap<String, Texture> text) {
        
        gl = gl1;
        //  activarAlmacen();
        // mater1 = mater;
      /*  Material mat1 = new Material(gl);
        float[] a = {0.05f, 0, 0.05f, 1};
        float[] d = {0.04f, .7f, .7f, 1};
        float[] s = {0.4f, 0.5f, 0.5f, 1};
        mat1.setMaterial(a, d, s, 2f);
        mater.put("cyan", mat1);
*/
        Material mat2 = new Material(gl);
        float[] a1 = {0.6f, 0.6f, 0.0745f, 1};
        float[] d1 = {0.75164f, .60648f, .22648f, 1};
        float[] s1 = {0.628281f, 0.555802f, 0.66065f, 1};
        mat2.setMaterial(a1, d1, s1, 72f);
        mater.put("gold", mat2);

        Material mat3 = new Material(gl);
        float[] a3 = {.6f, 0.01175f, 0.01175f, 1};
        float[] d3 = {0.1f, 0.01f, 0.01f, 1f};
        float[] s3 = {0.1f, 0.01f, 0.01f, 1f};
        mat3.setMaterial(a3, d3, s3, 0.6f);
        mater.put("ruby", mat3);

        Material mat4 = new Material(gl);
        float[] a4 = {0.05375f, 0.05f, 0.06625f, 1};
        float[] d4 = {0.18275f, 0.17f, .022525f, 1};
        float[] s4 = {0.332741f, 0.328634f, 0.346435f, 1};
        mat4.setMaterial(a4, d4, s4, 0.3f);
        mater.put("obsidiana", mat4);

        Material mat5 = new Material(gl);
        float[] a5 = {0.0215f, 0.1745f, 0.0215f, 0.55f};
        float[] d5 = {0.07568f, 0.61424f, 0.07568f, 0.55f};
        float[] s5 = {0.633f, 0.727811f, 0.633f, 0.55f};
        mat5.setMaterial(a5, d5, s5, 76.8f);
        mater.put("verde1", mat5);

        Material mat6 = new Material(gl);
        float[] a6 = {0.0f, 0.0f, 0.0f, 1.0f};
        float[] d6 = {0.5f, 0.5f, 0.0f, 1.0f};
        float[] s6 = {0.60f, 0.60f, 0.50f, 1.0f};
        mat6.setMaterial(a6, d6, s6, 32f);
        mater.put("amarello", mat6);

        Material mat7 = new Material(gl);
        float[] a7 = {0.8f, 0.8f, 0.8f, 1.0f};
        float[] d7 = {0.7f, 0.7f, 0.7f, 1.0f};
        float[] s7 = {0f, 0f, 0f, 1.0f};
        mat7.setMaterial(a7, d7, s7, 60f);
        mater.put("blanco1", mat7);

        Material mat8 = new Material(gl);
        float[] a8 = {0.0f, 0.0f, 0.0f, 1.0f};
        float[] d8 = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] s8 = {0.5f, 0.5f, 0.5f, 1.0f};
        mat8.setMaterial(a8, d8, s8, 32f);
        mater.put("negro", mat8);

        Material mat9 = new Material(gl);
        float[] a9 = {0.0215f, 0.0215f, 0.1745f, 0.55f};
        float[] d9 = {0.07568f, 0.07568f, 0.61424f, 0.55f};
        float[] s9 = {0.633f, 0.633f, 0.727811f, 0.55f};
        mat9.setMaterial(a9, d9, s9, 32.8f);
        mater.put("azul1", mat9);

        Material mat10 = new Material(gl);
        float[] a10 = {0.5f, 0.0215f, 0.0215f, 0.55f};
        float[] d10 = {0.61424f, 0.7568f, 0.7568f, 0.55f};
        float[] s10 = {0.727811f, 0.633f, 0.633f, 0.55f};
        mat10.setMaterial(a10, d10, s10, 32.8f);
        mater.put("rojo1", mat10);

        Material mat11 = new Material(gl);
        float[] a11 = {0.2f, .9f, .9f, 1.0f};
        float[] d11 = {0.1f, 0.1f, 0.1f, 1.0f};
        float[] s11 = {0, 0.1f, 0.1f, 1.0f};
        mat11.setMaterial(a11, d11, s11, 32.8f);
        mater.put("cyan1", mat11);

        Material mat12 = new Material(gl);
        float[] a12 = {1, 0f, 1f, 1.0f};
        float[] d12 = {1,0 , 1, 1.0f};
        float[] s12 = {1, 0, 1, 1.0f};
        mat12.setMaterial(a12, d12, s12, 32.8f);
        mater.put("magenta1", mat12);
        
        
        
               Material mat13 = new Material(gl);
        float[] a13 = {0.1745f,0.0215f , 0.0215f, 0.55f};
        float[] d13 = {0.61424f, 0.07568f, 0.07568f, 0.55f};
        float[] s13 = {0.727811f,0.633f , 0.633f, 0.55f};
        mat13.setMaterial(a13, d13, s13, 76.8f);
        mater.put("rojo2", mat13);
        
        
        
        
        try {
             Texture text1=TextureIO.newTexture(new File("Textures/ladrillo.jpg"), true);
            text.put("piedra", text1);
        
        } catch (IOException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GLException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
