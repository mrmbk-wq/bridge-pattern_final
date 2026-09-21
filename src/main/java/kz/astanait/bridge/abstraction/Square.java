package kz.astanait.bridge.abstraction;

import kz.astanait.bridge.implementor.Renderer;

public class Square extends Shape {

    private final double x;
    private final double y;
    private final double side;

    public Square(double x, double y, double side, Renderer renderer) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw() {
        renderer.renderSquare(x, y, side);
    }

    @Override
    public double area() {
        return side * side;
    }
}
