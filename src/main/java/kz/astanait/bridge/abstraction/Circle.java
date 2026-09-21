package kz.astanait.bridge.abstraction;

import kz.astanait.bridge.implementor.Renderer;

public class Circle extends Shape {

    private final double x;
    private final double y;
    private final double radius;

    public Circle(double x, double y, double radius, Renderer renderer) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(x, y, radius);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
