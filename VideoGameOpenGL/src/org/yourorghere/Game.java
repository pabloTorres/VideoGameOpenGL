package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Game.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Game implements GLEventListener {

    public static HashMap<String, Material> materiales = new HashMap<String, Material>();
    Light sol;
    Escena escena;
    Almacen alm;
    int auxCam = 0;
    Personaje person;
    ManejadorRaton mRaton;
    ManejadorTeclado mTeclado;

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Game());
        frame.add(canvas);
        frame.setSize(1280, 960);
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
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        person = new Personaje(0, 0, -5, 5f, gl);
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        // Enable VSync
        gl.setSwapInterval(1);
        mTeclado = new ManejadorTeclado(person, this);
        drawable.addKeyListener(mTeclado);
        mRaton = new ManejadorRaton();
        mRaton.init(drawable, person);

        escena = new Escena(gl);
        alm = new Almacen(gl, materiales);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);

        float[] ambient = {0.8f, 0.8f, 0.8f, .26f};
        float[] diffuse = {0.45f, 0.45f, 0.75f, 1};//{.6f, .6f, .6f, 1};
        float[] specular = {0.3f, 0.3f, 0.1f, 1};//{.4f, .4f, .4f, 1};

        sol = new Light(gl, 100, -500, 1023, ambient, diffuse, specular, true, GL.GL_LIGHT0);

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
        glu.gluPerspective(45.0f, h, 1.0, 150.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
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

        }
        if (auxCam == 3) {

            glu.gluLookAt(person.x, person.y + 2, person.z + 14, person.x + Math.cos(person.angley), person.y, person.z + Math.sin(person.angley), 0, 1, 0);

            gl.glPushMatrix();
            //gl.glTranslatef(person.x, person.y, person.z+1f);


            person.draw();
            person.actuar();

            gl.glPopMatrix();

        }
        escena.drawEsc();
        // Flush all drawing operations to the graphics card
        gl.glFlush();

        sol.activate();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
