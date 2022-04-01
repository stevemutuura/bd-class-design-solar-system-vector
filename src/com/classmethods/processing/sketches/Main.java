package com.classmethods.processing.sketches;

import math.Vector;
import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet applet;
    StarDrawer starDrawer;

    private Planet earth;
    private Planet mercury;
    private Planet mars;
    private Planet sun;

    public void settings() {
        applet = this;
        size(600, 600);
    }

    public void setup() {
        starDrawer = new StarDrawer();

        sun = new Planet(100, 50, 38, new Vector(width/2, height/2), new Vector(0,0), null);
        earth = new Planet(0.8f, 8, 160, new Vector(120, height/2), new Vector(0,-2), sun);
        mercury = new Planet(.6f, 10, 20, new Vector(200, height/2), new Vector(0,-2.5f), sun);
        mars = new Planet(1, 15, 0, new Vector(100, height/2), new Vector(0,-2.25f), sun);

        colorMode(HSB);
        noStroke();
    }

    public void draw() {
        fill(0,0,0,20);
        rect(0,0,width,height);
        starDrawer.drawStars();

        sun.drawSelf();

        earth.move();
        earth.drawSelf();
        mercury.move();
        mercury.drawSelf();
        mars.move();
        mars.drawSelf();
    }

    public static void main(String... args) {
        PApplet.main("com.classmethods.processing.sketches.Main");
    }
}