/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLException;

/**
 *
 * @author Admin
 */
public class Laberinto {

    GL gl;
    //Cubo c1;

    CuboT c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c101, c102, c103, c104, c105, c106, c107, c108, c109, c110, c111, c112, c113, c114, c115, c116, c117, c118, c11, c12, c13, c14, c15, c16, c17, c18,
            c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36,
            c37, c38,c39,c40,c41,c42;
    String num = "";
//    public static ArrayList<CuboGlut> cubosLab = new ArrayList();
    public static ArrayList<CuboT> cubosLab = new ArrayList();

    //Piramide p1;
    public Laberinto(GL gl) {
        this.gl = gl;

        c1 = new CuboT(gl, -30, 3, -90, 6, 6, 6);
        c2 = new CuboT(gl, -30, 3, -100, 6, 6, 6);
        c3 = new CuboT(gl, -30, 3, -110, 6, 6, 6);
        c4 = new CuboT(gl, -30, 3, -120, 6, 6, 6);
        c5 = new CuboT(gl, -30, 3, -130, 6, 6, 6);
        c6 = new CuboT(gl, -30, 3, -140, 6, 6, 6);
        c7 = new CuboT(gl, -30, 3, -150, 6, 6, 6);
        c8 = new CuboT(gl, -30, 3, -160, 6, 6, 6);
        c9 = new CuboT(gl, -30, 3, -170, 6, 6, 6);
        c10 = new CuboT(gl, -30, 3, -180, 6, 6, 6);
        c101 = new CuboT(gl, -30, 3, -190, 6, 6, 6);
        c102 = new CuboT(gl, -30, 3, -200, 6, 6, 6);
        c103 = new CuboT(gl, -20, 3, -200, 6, 6, 6);
        c104 = new CuboT(gl, -10, 3, -200, 6, 6, 6);
        c105 = new CuboT(gl, 0, 3, -200, 6, 6, 6);
        c106 = new CuboT(gl, 10, 3, -200, 6, 6, 6);
        c107 = new CuboT(gl, 20, 3, -200, 6, 6, 6);

        c108 = new CuboT(gl, 45, 3, -200, 6, 6, 6);
        c109 = new CuboT(gl, 57, 3, -200, 6, 6, 6);
        c110 = new CuboT(gl, 69, 3, -200, 6, 6, 6);
        c111 = new CuboT(gl, 78, 3, -200, 6, 6, 6);

        //bajada derec
        c112 = new CuboT(gl, 45, 3, -188, 6, 6, 6);
        c113 = new CuboT(gl, 45, 3, -176, 6, 6, 6);
        c114 = new CuboT(gl, 35, 3, -176, 6, 6, 6);
        c115 = new CuboT(gl, 25, 3, -176, 6, 6, 6);
        c116 = new CuboT(gl, 57, 3, -176, 6, 6, 6);

        c117 = new CuboT(gl, 57, 3, -150, 6, 6, 6);

        c118 = new CuboT(gl, 57, 3, -138, 6, 6, 6);

        c31 = new CuboT(gl, 57, 3, -126, 6, 6, 6);
        c32 = new CuboT(gl, 57, 3, -114, 6, 6, 6);

        c33 = new CuboT(gl, 69, 3, -126, 6, 6, 6);
        c34 = new CuboT(gl, 80, 3, -126, 6, 6, 6);

        // c2 = new CuboT(gl, -10, 3, -90, 6, 6, 6);
        // c3 = new CuboT(gl, 0, 3, -90, 6, 6, 6);
        // c4 = new CuboT(gl, 10, 3, -90, 6, 6, 6);
        cubosLab.add(c1);
        cubosLab.add(c2);
        cubosLab.add(c3);
        cubosLab.add(c4);
        cubosLab.add(c5);
        cubosLab.add(c6);
        cubosLab.add(c7);
        cubosLab.add(c8);
        cubosLab.add(c9);
        cubosLab.add(c10);
        cubosLab.add(c101);
        cubosLab.add(c102);
        cubosLab.add(c103);
        cubosLab.add(c104);
        cubosLab.add(c105);
        cubosLab.add(c106);
        cubosLab.add(c107);
        cubosLab.add(c108);
        cubosLab.add(c109);
        cubosLab.add(c110);
        cubosLab.add(c111);
        cubosLab.add(c112);
        cubosLab.add(c113);
        cubosLab.add(c114);
        cubosLab.add(c115);
        cubosLab.add(c116);
        cubosLab.add(c117);
        cubosLab.add(c118);
        cubosLab.add(c31);
        cubosLab.add(c32);
        cubosLab.add(c33);
        cubosLab.add(c34);

        c11 = new CuboT(gl, -5, 3, -90, 6, 6, 6);
        c12 = new CuboT(gl, 5, 3, -90, 6, 6, 6);
        c13 = new CuboT(gl, 15, 3, -90, 6, 6, 6);
        c14 = new CuboT(gl, 25, 3, -90, 6, 6, 6);
        c15 = new CuboT(gl, 35, 3, -90, 6, 6, 6);
        c16 = new CuboT(gl, 45, 3, -90, 6, 6, 6);
        c17 = new CuboT(gl, 55, 3, -90, 6, 6, 6);
        c18 = new CuboT(gl, 65, 3, -90, 6, 6, 6);

        cubosLab.add(c11);
        cubosLab.add(c12);
        cubosLab.add(c13);
        cubosLab.add(c14);
        cubosLab.add(c15);
        cubosLab.add(c16);
        cubosLab.add(c17);
        cubosLab.add(c18);

        c19 = new CuboT(gl, 90, 3, -90, 6, 6, 6);
        c20 = new CuboT(gl, 90, 3, -100, 6, 6, 6);
        c21 = new CuboT(gl, 90, 3, -110, 6, 6, 6);
        c22 = new CuboT(gl, 90, 3, -120, 6, 6, 6);
        c23 = new CuboT(gl, 90, 3, -130, 6, 6, 6);
        c24 = new CuboT(gl, 90, 3, -140, 6, 6, 6);
        c25 = new CuboT(gl, 90, 3, -150, 6, 6, 6);
        c26 = new CuboT(gl, 90, 3, -160, 6, 6, 6);
        c27 = new CuboT(gl, 90, 3, -170, 6, 6, 6);
        c28 = new CuboT(gl, 90, 3, -180, 6, 6, 6);
        c29 = new CuboT(gl, 90, 3, -190, 6, 6, 6);
        c30 = new CuboT(gl, 90, 3, -200, 6, 6, 6);

        cubosLab.add(c19);
        cubosLab.add(c20);
        cubosLab.add(c21);
        cubosLab.add(c22);
        cubosLab.add(c23);
        cubosLab.add(c24);
        cubosLab.add(c25);
        cubosLab.add(c26);
        cubosLab.add(c27);
        cubosLab.add(c28);
        cubosLab.add(c29);
        cubosLab.add(c30);

        c35 = new CuboT(gl, -18, 3, -150, 6, 6, 6);
        c36 = new CuboT(gl, -6, 3, -150, 6, 6, 6);
        c37 = new CuboT(gl, 17, 3, -150, 6, 6, 6);
        c38 = new CuboT(gl, 28, 3, -150, 6, 6, 6);
        //   c37 = new CuboT(gl, -30, 3, -150, 6, 6, 6);
        //   c38 = new CuboT(gl, -30, 3, -150, 6, 6, 6);

        cubosLab.add(c36);
        cubosLab.add(c35);
        cubosLab.add(c37);
        cubosLab.add(c38);

        c39 = new CuboT(gl, 16, 3, -90, 6, 6, 6);
        c40 = new CuboT(gl, 16, 3, -102, 6, 6, 6);
        c41 = new CuboT(gl, 16, 3, -114, 6, 6, 6);
        c42 = new CuboT(gl, 16, 3, -126, 6, 6, 6);
        cubosLab.add(c39);
        cubosLab.add(c40);
        cubosLab.add(c41);
        cubosLab.add(c42);
    }

    public void draw() {

        for (CuboT c : cubosLab) {
            gl.glPushMatrix();

            c.draw();
            gl.glPopMatrix();

        }

//System.out.println(c1.getX());
    }

}
