package kz.astanait.bridge.abstraction;

import kz.astanait.bridge.implementor.Renderer;
public abstract class Shape {

    protected Renderer renderer;

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract void draw();
    public abstract double area();
    public String getRendererName() {
        return renderer.getName();
    }
}
