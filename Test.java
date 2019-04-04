import processing.core.PApplet;
import processing.core.PImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test extends PApplet {
    private PImage img;
    private float heldX = 200;
    private float heldY = 200;
    private boolean jumping;
    private int jumpCount =2;
    private float gravity = 9F;
    private boolean cooliding;
    public float getHeldX() {
        return heldX;
    }

    public void setHeldX(float heldX) {
        this.heldX = heldX;
    }

    public float getHeldY() {
        return heldY;
    }

    public void setHeldY(float heldY) {
        this.heldY = heldY;
    }

    private float t = 1/30F;
    public static void main(String[] args) {
        PApplet.main(Test.class, args);


    }

    public void setup() {
        super.setup();
        System.out.println("hier ist setup");
        background(0);
        frameRate(30);
        loop();
        img = loadImage("Resources/held.png");
    }

    public void settings() {
        super.settings();

        size(800, 800);
        System.out.println("hier wird settings aufgerufen");

    }

    public void draw() {
        background(0);
        //image(held.getImg(), held.getPositionX(), held.getPositionY());
        image(img,heldX,heldY);

        springen();
        if(getHeldY() >= 300){
            cooliding = true;
            setHeldY(300);
            jumpCount = 2;
            t= 1/20;
        }
        System.out.println(t);




    }
    public void springen(){
        // Ys = V0 * t - 1/2 g * t^2
        // g = 10
        // t = i
        // v0 = 5



        if(jumping == true && cooliding == false ) {

            t += 1 / 20F;
            // werte um v 7 g= 7 sind ok
            float v = 8F;
            //float g = 9F;
            float test = 1 / 2f;

            float vel = v * t;
            float grav = 1 / 2f * gravity * (t * t);

            float sprung = vel - grav;
            // System.out.println(vel);
            //  System.out.println(grav);

            //  t += 1/30F;


            setHeldY(getHeldY() - sprung);
        }


    }
    @Override
    public void keyPressed(){
        if(key == 'w' && jumpCount >0){
            jumping = true;
            cooliding = false;
           // t = 0.5F;
           // jumpCount -= 1;
            // ggf hier die jump methode aufrufen und noch eine gravity funktion einfügen die nach loslassen funzt
        }
    }
    public void keyReleased(){
        if(key == 'w'){
            //jumping = false;
            jumpCount -= 1;
            t= 1/20;
        }
    }


    }
