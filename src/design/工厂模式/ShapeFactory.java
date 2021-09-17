package design.工厂模式;

public class ShapeFactory {

    public static final String CIRCLE = "CIRCLE";
    public static final String RECT = "RECT";

    public Shape getShape(String shapeStr) {
        if (shapeStr == null)
            return null;

        if (shapeStr.equalsIgnoreCase(CIRCLE)) {
            return new Circle();
        } else if (shapeStr.equalsIgnoreCase(RECT)) {
            return new Rect();
        } else {
            return null;
        }

    }
}
