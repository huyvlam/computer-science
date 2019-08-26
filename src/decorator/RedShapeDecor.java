package decorator;

public class RedShapeDecor extends ShapeDecor {
    public RedShapeDecor(Shape decorShape) {
        super(decorShape);
    }
    
    public void draw() {
        decorShape.draw();
        setRedBorder(decorShape);
    }
    
    private void setRedBorder(Shape decorShape) {
        System.out.println("Border color: red");
    }
}
