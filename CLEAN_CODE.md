# Clean Code Principles Applied

Five principles, each with a short "before" (what a naive/violating version
would look like) and "after" (what this repo actually does).

## 1. Clear separation of abstraction-side vs. implementation-side responsibilities

**Before (violation):**
```java
class Circle {
    void draw(String mode) {
        if (mode.equals("vector")) {
            System.out.println("<circle .../>");
        } else if (mode.equals("raster")) {
            System.out.println("Rasterizing circle...");
        }
    }
}
```
Circle now knows about every rendering technology and must change whenever
a new one is added.

**After:**
```java
class Circle extends Shape {
    public void draw() {
        renderer.renderCircle(x, y, radius);   // no rendering detail here
    }
}
```
`Circle` only knows *that* it can be rendered, never *how*.

## 2. Meaningful names distinguishing Abstraction vs. Implementor roles

**Before:** classes named `ShapeA`, `ShapeB`, `Helper1`, `Helper2`.

**After:** `Shape` / `Circle` / `Square` (abstraction side) vs.
`Renderer` / `VectorRenderer` / `RasterRenderer` (implementor side). The
suffix `Renderer` consistently marks the implementation hierarchy, so the
reader always knows which side of the bridge a class belongs to.

## 3. Small, focused classes on both sides of the bridge

**Before:** one `ShapeRenderer` god-class with a `switch` over shape type
*and* rendering mode (4 branches, growing multiplicatively).

**After:** each class has one reason to change — `Circle`/`Square` change
only for geometry reasons, `VectorRenderer`/`RasterRenderer` only for
rendering-technology reasons. No class exceeds ~30 lines.

## 4. No duplicated logic between Concrete Implementors

**Before:** both `VectorRenderer` and `RasterRenderer` each re-implement
their own `printf` formatting boilerplate copy-pasted from one another,
with area math duplicated inside the renderer too.

**After:** each `Renderer` implementation owns only its own drawing
strategy; shape geometry (`area()`) stays in `Shape`/`Circle`/`Square` and
is never recomputed inside a renderer, so there is a single source of
truth for geometry and a single source of truth per rendering technology.

## 5. Backward-compatible / open-for-extension design

**Before:** adding a new renderer means editing an `if/else` inside every
shape class.

**After:** adding `RayTracedRenderer implements Renderer` requires **zero**
changes to `Shape`, `Circle`, or `Square` — only a new class that
implements the existing `Renderer` interface. Likewise, adding a new
`Triangle extends Shape` requires no change to any `Renderer`. This is the
Open/Closed Principle in action, and it is the direct payoff of the Bridge
pattern's composition link.
