package decorator;

public abstract class ShapeDecor implements Shape {
    protected Shape decorShape;
    
    public ShapeDecor(Shape decorShape) {
        this.decorShape = decorShape;
    }
    
    public void draw() {
        decorShape.draw();
    }
}
