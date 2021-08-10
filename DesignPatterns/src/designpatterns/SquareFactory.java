
package designpatterns;


public class SquareFactory implements RectangleFactoryInterface {

    @Override
    public Rectangle createRectangle() {
        return new Square(4);
    }
    
}
