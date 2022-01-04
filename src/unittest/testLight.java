package unittest;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import Geometrics.Plane;
import Geometrics.Sphere;
import Geometrics.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class testLight{

    @Test
    public void testLight() {

        Scene scene = new Scene("MyLightTest");
        scene.setBackground(new Color(169, 117, 147));
        scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.setScreenDistance(300);
        scene.setAmbientLight(new AmbientLight(new Color(103, 25, 43), 0.1));

        Material m1 = new Material(90 , 1,40);

        Triangle triangle1 = new Triangle(new Point3D(60, -60, 50),
                new Point3D(-20, 100, 50),
                new Point3D(60, 100, 50),
                new Color (8, 72, 124));
        triangle1.setMaterial(m1);
        scene.addGeometry(triangle1);

        Triangle triangle2 = new Triangle(new Point3D(50, -100, 200),
                new Point3D(-80, 100, 200),
                new Point3D(100, 100, 200),
                new Color (201, 5, 5));
        triangle2.setMaterial(m1);
        scene.addGeometry(triangle2);

        Sphere s1 = new Sphere( new Point3D(-14,-14, 150),60, new Color(38, 204, 227));
        s1.setMaterial(new Material(1,1,20));
        scene.addGeometry(s1);

        Plane plane = new Plane(new Point3D(-100,20,0), new Vector(30,-200, 0), new Color(194, 70, 13));
        plane.setMaterial(m1);
        scene.addGeometry(plane);

        scene.addLight(new PointLight(new Color(241, 236, 236), new Point3D(10, 10, -75),
                0.1, 0.001, 0.015));

        scene.addLight(new SpotLight(new Color(187, 24, 122), new Point3D(100,10,10)
                ,new Vector(30,300,30), 70,90,100 ));

        ImageWriter imageWriter = new ImageWriter("testLight", 1000, 1000, 1000, 1000);

        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();

    }
}

