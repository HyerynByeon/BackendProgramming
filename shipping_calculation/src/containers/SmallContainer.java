package containers;

//HyerynByeon, 24605137

public class SmallContainer extends Container {
    public SmallContainer(double length, double width, double height) {
        super(length, width, height);
        setShippingCost(1000.0); // Set the shipping cost for small containers
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }


}
