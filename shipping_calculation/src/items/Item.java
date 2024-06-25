package items;

//HyerynByeon, 24605137

import java.util.ArrayList;
import java.util.List;

//Item class
public class Item {
    private String name;
    private double length;
    private double width;
    private double height;

    private double weight;

    //Constructors
    public Item(String name, double length, double width, double height, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    //Getter and setters
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setLength(double length){
        this.length = length;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    //Calculate Volume
    public double calculateVolume() {
        return length * width * height;
    }

    //Print item info
    public void printItemInfo() {
        System.out.println();
        System.out.println("Item: " + name);
        System.out.println("Dimensions (cm): " + length + "x" + width + "x" + height);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Volume: " + calculateVolume() + " cm^3");
        System.out.println();
    }
}
