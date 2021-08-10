
package designpatterns;

public class RectangleFactory implements RectangleFactoryInterface {

    @Override
    public Rectangle createRectangle() {
        return new Rectangle(4, 2);
    }
    
}
