package design.工厂模式;

public class TestFactory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.getShape(ShapeFactory.CIRCLE);
        shape.draw();

        Shape shape1 = shapeFactory.getShape(ShapeFactory.RECT);
        shape1.draw();
    }
}
