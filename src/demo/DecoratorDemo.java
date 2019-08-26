package demo;

import decorator.*;

public class DecoratorDemo {
	public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecor(new Circle());
        Shape redRectangle = new RedShapeDecor(new Rectangle());

        circle.draw();
        redCircle.draw();
        redRectangle.draw();
	}
}
