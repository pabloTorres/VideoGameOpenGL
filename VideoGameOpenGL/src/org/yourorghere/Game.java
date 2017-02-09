package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.texture.Texture;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import com.sun.opengl.util.texture.TextureIO;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

/**
 * Game.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Game implements GLEventListener {

    //Cubo malla;
    public static HashMap<String, Material> materiales = new HashMap<String, Material>();
    public static HashMap<String, Texture> texturas = new HashMap<String, Texture>();
    Light sol;
    Escena escena;
    Almacen alm;
    float vidaEn = 0;
    float vidaEn1 = 0;
    float vidaEn11 = 0;
    float vidaEn12 = 0;
    float vidaEn13 = 0;
    float count = 0;
    float vidaK = 0;
    float colisionE = 0;
    float colisionE2 = 0;
    float colisionE3 = 0;
    int auxCam = 0;
    public static Jugador person;
    Enemigo en, en1;
    Enemigo2 enemigo1;
    Enemigo2 enemigo2;
    Enemigo2 enemigo3;
    Presos preso1, preso2, preso3, preso4;
    ManejadorRaton mRaton;
    ManejadorTeclado mTeclado;
    float disparo = 0;
    TextRenderer textRenderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 80));
    TextRenderer textRenderer1 = new TextRenderer(new Font("SansSerif", Font.BOLD, 50));
    Llave llave;

    float height = 0;
    float width = 0;

    // Texture tex;

    /*
    
     hablitar tex.enable();
    
     ligar tex.bind();
    
     front
     gl.glNormal
     gl.glTexCoord2f(1,1)
     gl.glvertes
     gl.gltexCoord2d(1,0)
    
     */
    public static void main(String[] args) {

        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Game());
        frame.add(canvas);
        frame.setSize(1366, 768);

        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLUT glut = new GLUT();
        // Cubo malla = new Cubo(gl);
        person = new Jugador(5, 3, 160, 1.8f, gl);
        en = new Enemigo(0, 29.6f, -45f, 5f, gl);
        en1 = new Enemigo(70, 29.6f, -45f, 5f, gl);

        enemigo1 = new Enemigo2(30, 6, -70, 0.3f, gl);
        enemigo2 = new Enemigo2(50, 6, -295, 0.3f, gl);
        enemigo3 = new Enemigo2(50, 6, -345, 0.3f, gl);

        preso1 = new Presos(80, 7, -260, 0.3f, gl);
        preso2 = new Presos(80, 7, -300, 0.3f, gl);
        preso3 = new Presos(-10, 7, -260, 0.3f, gl);
        preso4 = new Presos(-10, 7, -300, 0.3f, gl);

        llave = new Llave(55, 3, -189, 2, gl, glut);
        // enemigo1 = new Enemigo2(30, 6, -10, 0.3f, gl);
        //    System.err.println("INIT GL IS: " + gl.getClass().getName());
        // Enable VSync
        gl.setSwapInterval(1);
        mTeclado = new ManejadorTeclado(person, this);
        drawable.addKeyListener(mTeclado);

        //  
        mRaton = new ManejadorRaton();
        mRaton.init(drawable, person);

        escena = new Escena(gl);
        alm = new Almacen(gl, materiales, texturas);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_TEXTURE_2D);

        float[] ambient = {0.8f, 0.8f, 0.8f, .26f};
        float[] diffuse = {0.45f, 0.45f, 0.75f, 1};//{.6f, .6f, .6f, 1};
        float[] specular = {0.3f, 0.3f, 0.1f, 1};//{.4f, .4f, .4f, 1};

        sol = new Light(gl, 500, -350, 93, ambient, diffuse, specular, true, GL.GL_LIGHT0);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        gl.glEnable(GL.GL_DEPTH_TEST);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, h, 1.2, 500.0);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        /*
         TExtura creo
         */
//gl.glTexEnvi(gl.GL_TEXTURE_ENV, gl.GL_TEXTURE_ENV_MODE, gl.GL_DECAL);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        /*
         if (auxCam == 1) {
         glu.gluLookAt(person.x, person.y, person.z, person.x + Math.cos(person.angley), (person.y), person.z + Math.sin(person.angley), 0, 1, 0);
         }

         if (auxCam == 2) {

         glu.gluLookAt(0, +4, +20, person.x + Math.cos(person.angley), person.y, person.z + Math.sin(person.angley), 0, 1, 0);

         gl.glPushMatrix();
         //gl.glTranslatef(person.x, person.y, person.z+1f);
         gl.glTranslatef(person.x, (person.y), person.z);
         gl.glRotatef(-(float) Math.toDegrees(person.angley), 0, 1, 0);
         gl.glRotatef(90, 0, 1, 0);
         person.draw();
         gl.glPopMatrix();

         }*/
        if (auxCam == 3) {

            // glu.gluLookAt(person.x  , person.y + 2, person.z + 14, person.x + Math.cos(person.angley), person.y, person.z + Math.sin(person.angley), 0, 1, 0);
            glu.gluLookAt(person.x + Math.cos(person.angley + Math.PI), person.y + 3, (Math.sin(person.angley + Math.PI) + person.z), person.getX(), person.getY() + 3, person.getZ(), 0, 1, 0);
            gl.glPushMatrix();
            //gl.glTranslatef(person.x, person.y, person.z+1f);

            person.draw();
            person.actuar();

            en.draw();
            //   en.disparar();
            en.actuar();
            en1.draw();
            en1.actuar();
            en.getAngleY(person);
            en.getAngleX(person);

            en1.getAngleY(person);
            en1.getAngleX(person);

            if (disparo % 10 == 0) {
                en.disparar();
                en1.disparar();
            }

            enemigo1.draw();
            enemigo2.draw();
            enemigo3.draw();
            preso1.draw();
            preso2.draw();
            preso3.draw();
            preso4.draw();
            llave.drawKey();

            //vista enemigos
            enemigo1.getAngleY(person);
            enemigo2.getAngleY(person);
            enemigo3.getAngleY(person);

            //vista presos
            preso1.getAngleY(person);
            preso2.getAngleY(person);
            preso3.getAngleY(person);
            preso4.getAngleY(person);
            preso4.getAngleX(person);
            gl.glPopMatrix();
            Yang2.rot += 5f;
            disparo += 1;
        }

        //colisiones bala-enemigo
        for (Bala bala : person.balas) {

            if (Metodos_Aux.Colision(bala, en)) {
                vidaEn = vidaEn + 1;
                //   System.out.println("hola");
                if (vidaEn == 3) {
                    en.alive = false;

                }

            }
            if (Metodos_Aux.Colision(bala, en1)) {
                //   System.out.println("hola");
                vidaEn1 = vidaEn1 + 1;
                //   System.out.println("hola");
                if (vidaEn1 == 3) {
                    en1.alive = false;

                }

            }

        }

        for (Bala bala : person.balas) {

            if (Metodos_Aux.Colision(bala, enemigo1)) {
                vidaEn11 = vidaEn11 + 1;
                //   System.out.println("hola");
                if (vidaEn11 == 20) {
                    enemigo1.alive = false;

                }

            }

            if (Metodos_Aux.Colision(bala, enemigo2)) {
                //   System.out.println("hola");
                vidaEn12 = vidaEn12 + 1;
                //   System.out.println("hola");
                if (vidaEn12 == 20) {
                    enemigo2.die();

                }

            }

            if (Metodos_Aux.Colision(bala, enemigo3)) {
                //   System.out.println("hola");
                vidaEn13 = vidaEn13 + 1;
                //   System.out.println("hola");
                if (vidaEn13 == 20) {
                    enemigo3.die();

                }

            }

        }
        for (Bala bala : en.balas) {

            if (Metodos_Aux.Colision(bala, person)) {
                vidaK += 1;
                //   System.out.println("hola");
                if (vidaK == 5) {
                    person.die();
                    vidaK = 0;
                }

            }

        }

        for (Bala bala : en1.balas) {

            if (Metodos_Aux.Colision(bala, person)) {
                vidaK += 1;
                //   System.out.println("hola");
                if (vidaK == 5) {
                    person.alive = false;
                    vidaK = 0;
                }

            }

        }

//fin colisiones: bala-enemigo
        //colisiones laberinto
        for (CuboT c : Laberinto.cubosLab) {
            if (Metodos_Aux.Colision(person, c)) {
                Metodos_Aux.repeler(person, c);
            }
        }

        //fin colisiones laberinto
        //animacion puerta
        if (en1.alive == false && en.alive == false) {
            escena.c1.giro = true;
            Metodos_Aux.seguir(enemigo1, person);

        }

        if (enemigo1.alive == false) {
            Metodos_Aux.seguir(enemigo2, person);
            enemigo2.x=-10;
            
            Metodos_Aux.seguir(enemigo3, person);
               enemigo3.x=+10;
        }

        if (llave.key == true) {
            Metodos_Aux.seguir(preso1, person);
            Metodos_Aux.seguir(preso2, person);
            Metodos_Aux.seguir(preso3, person);
            Metodos_Aux.seguir(preso4, person);
            preso2.der();
            preso1.izq();
            preso3.retroceder();
            preso2.avanzar();
        }

        if (Metodos_Aux.Colision(llave, person)) {
            llave.key = true;

        }

        if (person.x > 170 && preso1.x > 170) {
            System.exit(0);

        }

        //Colisiones enemigo giro
        if (Metodos_Aux.Colision(enemigo1, person)) {
            colisionE += 1;
            if (colisionE % 8 == 0 && enemigo1.alive == true) {
                vidaK += 1;
                //  System.err.println("me dieron");
                colisionE = 0;
            }

            if (vidaK == 5) {
                person.die();
                vidaK = 0;
            }

        }

        if (Metodos_Aux.Colision(enemigo2, person)) {
            colisionE2 += 1;
            if (colisionE2 % 8 == 0 && enemigo2.alive == true) {
                vidaK += 1;
                //   System.err.println("me dieron");
                colisionE2 = 0;
            }

            if (vidaK == 5) {
                person.die();
                vidaK = 0;
            }

        }

        if (Metodos_Aux.Colision(enemigo3, person)) {
            colisionE3 += 1;
            if (colisionE3 % 8 == 0 && enemigo3.alive == true) {
                vidaK += 1;
                //  System.err.println("me dieron");
                colisionE3 = 0;
            }

            if (vidaK == 5) {
                person.die();
                vidaK = 0;
            }

        }

        //gl.glPus
        escena.drawEsc();
        if (person.alive == false) {

            textRenderer.beginRendering(900, 700);
            textRenderer.setColor(Color.YELLOW);
            textRenderer.setSmoothing(true);
            textRenderer.draw("GAME OVER!!", (int) (250), (int) (300));
            textRenderer.endRendering();
        }

        if (preso1.z > -60 && llave.key) {

            textRenderer.beginRendering(900, 700);
            textRenderer.setColor(Color.YELLOW);
            textRenderer.setSmoothing(true);
            textRenderer.draw("You WIN!!", (int) (250), (int) (300));
            textRenderer.endRendering();
        }

        if (vidaK == 0) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw("00000", (int) (700), (int) (70));
            textRenderer1.endRendering();
        }

        if (llave.key) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw("llave", (int) (700), (int) (300));
            textRenderer1.endRendering();
        }

        if (vidaK == 1) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw(" 0000", (int) (700), (int) (70));
            textRenderer1.endRendering();
        }
        if (vidaK == 2) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw("  000", (int) (700), (int) (70));
            textRenderer1.endRendering();
        }
        if (vidaK == 3) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw("   00", (int) (700), (int) (70));
            textRenderer1.endRendering();
        }
        if (vidaK == 4) {
            textRenderer1.beginRendering(900, 700);
            textRenderer1.setColor(Color.GREEN);
            textRenderer1.setSmoothing(true);

            textRenderer1.draw("    0", (int) (700), (int) (70));
            textRenderer1.endRendering();
        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();

        sol.activate();
        checkKeys();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void checkKeys() {

        if (ManejadorTeclado.keyStates['w']) {
            person.avanzar();
        }

        if (ManejadorTeclado.keyStates['s']) {
            person.retroceder();
        }

        if (ManejadorTeclado.keyStates['a']) {
            person.izq();
        }

        if (ManejadorTeclado.keyStates['d']) {
            person.der();
        }

        if (ManejadorTeclado.keyStates['g']) {
            en.die();
            en1.die();
            enemigo1.die();
            enemigo2.die();
            enemigo3.die();

        }

        if (ManejadorTeclado.keyStates['f']) {

            preso1.z -= 10;
            preso2.z -= 10;
            preso3.z -= 10;
            preso4.z -= 10;

        }
    }

}
