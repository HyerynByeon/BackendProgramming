package containers;

//HyerynByeon, 24605137

public class BigContainer extends Container {
    public BigContainer(double length, double width, double height) {
        super(length, width, height);
        setShippingCost(1800.0); // Set the shipping cost for big containers
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }



}
