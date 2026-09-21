package kz.astanait.bridge.implementor;
public class RasterRenderer implements Renderer {

    @Override
    public void renderCircle(double x, double y, double radius) {
        int pixelCount = (int) Math.round(Math.PI * radius * radius);
        System.out.printf(
            "[RASTER] Rasterizing circle at (%.1f, %.1f), r=%.1f -> ~%d pixels%n",
            x, y, radius, pixelCount
        );
    }

    @Override
    public void renderSquare(double x, double y, double side) {
        int pixelCount = (int) Math.round(side * side);
        System.out.printf(
            "[RASTER] Rasterizing square at (%.1f, %.1f), side=%.1f -> %d pixels%n",
            x, y, side, pixelCount
        );
    }

    @Override
    public String getName() {
        return "Raster (bitmap) renderer";
    }
}
