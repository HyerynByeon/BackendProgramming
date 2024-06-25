package containers;

//HyerynByeon, 24605137

public abstract class Container {
	private double length;
    private double width;
    private double height;
    private double shippingCost;
    private double maxWeight;

    //Constructors
    public Container(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //Getter and Setters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    //Calculate Volume
    public abstract double calculateVolume();

    //Set shipping cost
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setLength(double length){
        this.length = length;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }

    //Print container info
    public void printContainerInfo() {
        System.out.println("Container Details");
        System.out.println("Container Dimensions (cm): " + length + "x" + width + "x" + height);
        System.out.println("Container Volume: " + calculateVolume() + " cm^3");
        System.out.println("Shipping Cost: " + shippingCost + " Euro");
    }
}

