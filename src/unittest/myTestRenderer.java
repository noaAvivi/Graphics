package unittest;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Elements.Camera;
import Geometrics.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;

public class myTestRenderer {

    @Test
    public void basicRenderTwoColorTest(){
        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setScreenDistance(100) ;
        scene.setBackground(new Color(176, 121, 94, 255));

        scene.addGeometry(new Triangle(new Point3D(40, 20, 100), new Point3D(-40, 200, 100), new Point3D(90, 200, 100),new Color(86, 35, 6)));
        scene.addGeometry(new Triangle(new Point3D(40, 20, 100), new Point3D(-50, 200, 100), new Point3D(-200, 50, 100),new Color(58, 24, 4)));
        scene.addGeometry(new Triangle(new Point3D(40, 20, 90), new Point3D(90, 180, 90), new Point3D(180, 150, 90),new Color(103, 50, 14)));
        scene.addGeometry(new Triangle(new Point3D(40, 20, 70), new Point3D(200, 150, 90), new Point3D(250, 100, 90),new Color(133, 66, 35)));
        scene.addGeometry(new Triangle(new Point3D(100, 0, 70), new Point3D(0, 100, 70), new Point3D(30, -30, 70),new Color(255, 204, 145)));
        scene.addGeometry(new Triangle(new Point3D(80, -250, 60), new Point3D(400, -160, 60), new Point3D(100, 100, 60),new Color(9, 6, 6)));
        ImageWriter imageWriter = new ImageWriter("MyRender", 500, 500, 500, 500);
        Renderer render = new Renderer(scene, imageWriter);

        render.renderImage();
    }
}
