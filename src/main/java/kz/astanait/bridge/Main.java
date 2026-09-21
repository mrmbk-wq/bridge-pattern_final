package kz.astanait.bridge;

import kz.astanait.bridge.abstraction.Circle;
import kz.astanait.bridge.abstraction.Shape;
import kz.astanait.bridge.abstraction.Square;
import kz.astanait.bridge.implementor.RasterRenderer;
import kz.astanait.bridge.implementor.Renderer;
import kz.astanait.bridge.implementor.VectorRenderer;


public class Main {

    public static void main(String[] args) {
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        Shape circle = new Circle(0, 0, 5, vector);
        Shape square = new Square(10, 10, 4, raster);

        System.out.println("--- Initial configuration ---");
        printShape(circle);
        printShape(square);

        System.out.println("\n--- Switching renderers at runtime (no change to Shape code) ---");
        circle.setRenderer(raster);
        square.setRenderer(vector);

        printShape(circle);
        printShape(square);
    }

    private static void printShape(Shape shape) {
        System.out.println("Using: " + shape.getRendererName());
        shape.draw();
        System.out.printf("Area: %.2f%n%n", shape.area());
    }
}
