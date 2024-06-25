package methods;

//HyerynByeon, 24605137

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import containers.Container;
import containers.BigContainer;
import containers.SmallContainer;
import gui.GUI;
import items.Item;

public class Calculation {
    private List<Item> items;
    private List<Integer> order;
    private List<Container> containers;

    public Calculation() {
        items = new ArrayList<>();
        order = new ArrayList<>();
        containers = new ArrayList<>();
    }

    public double calculateShippingPrice() {
        double totalPrice = 0.0;
        for (Container container : containers) {
            totalPrice += container.getShippingCost();
        }
        return totalPrice;
    }

    //The addItems method
    public void addItems(Item item) {
        items.add(item);
    }

    //The addOrder method
    public void addOrder(int quantity) {
        order.add(quantity);
    }

    //The totalVolume method
    public double totalVolume() {
        double totalVolume = 0.0;
        for (Item item : items) {
            totalVolume += item.calculateVolume();
        }
        return totalVolume;
    }
    
    //For GUI purpose
    public double calculateTotalVolume() {
        return totalVolume();
    }

    //The totalWeight method
    public double totalWeight() {
        double totalWeight = 0.0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    //For GUI purpose
    public double calculateTotalWeight() {
        return totalWeight();
    }

    //The bestShipping method
    public List<String> bestShipping(Container bigContainer, Container smallContainer) {
        List<String> res = new ArrayList<>();

        double totalVolume = totalVolume();
        double totalWeight = totalWeight();

        int bigContainerCount = (int) Math.ceil(totalVolume / bigContainer.calculateVolume());
        double bigContainerCost = shippingPrice(bigContainerCount, totalWeight, bigContainer);

        int smallContainerCount = (int) Math.ceil(totalVolume / smallContainer.calculateVolume());
        double smallContainerCost = shippingPrice(smallContainerCount, totalWeight, smallContainer);

        int maxBigContainers = (int) Math.floor(totalVolume / bigContainer.calculateVolume());
        int maxSmallContainers = (int) Math.floor(totalVolume / smallContainer.calculateVolume());

        if (totalVolume % bigContainer.calculateVolume() != 0) {
            maxBigContainers++;
        }

        if (totalVolume % smallContainer.calculateVolume() != 0) {
            maxSmallContainers++;
        }
        double totalCost = Double.MAX_VALUE;
        int bestBigCount = 0;
        int bestSmallCount = 0;

        for (int bigCount = 0; bigCount <= maxBigContainers; bigCount++) {
            for (int smallCount = 0; smallCount <= maxSmallContainers; smallCount++) {
                double currentTotalCost = bigCount * bigContainer.getShippingCost() + smallCount * smallContainer.getShippingCost();
                double currentTotalVolume = bigCount * bigContainer.calculateVolume() + smallCount * smallContainer.calculateVolume();

                if (currentTotalVolume >= totalVolume && currentTotalCost < totalCost) {
                    totalCost = currentTotalCost;
                    bestBigCount = bigCount;
                    bestSmallCount = smallCount;
                }
            }
        }

        if (bigContainerCost <= totalCost && bigContainerCost <= smallContainerCost && bigContainerCost < shippingPrice(bestBigCount, totalWeight, bigContainer)) {
            bestBigCount = bigContainerCount;
            bestSmallCount = 0;
            totalCost = bigContainerCost;
        } else if (smallContainerCost <= totalCost && smallContainerCost <= bigContainerCost && shippingPrice(bestSmallCount, totalWeight, smallContainer) < totalCost) {
            bestBigCount = 0;
            bestSmallCount = smallContainerCount;
            totalCost = smallContainerCost;
        }

        double finalCost = shippingPrice(bestBigCount, totalWeight, bigContainer) + shippingPrice(bestSmallCount, totalWeight, smallContainer);

        System.out.println("Best shipping method: " + bestBigCount + " big containers and " + bestSmallCount + " small containers");
        System.out.println("Total cost: " + finalCost + " Euro");

        res.add(0, String.valueOf(bestBigCount));
        res.add(1,String.valueOf(bestSmallCount));
        res.add(2,String.valueOf(finalCost));

        return res;
    }

	//The shippingPrice method
    public double shippingPrice(int containerCount, double totalWeight, Container container) {
        if (container instanceof BigContainer) {
            return containerCount * container.getShippingCost();
        } else if (container instanceof SmallContainer) {
            if (containerCount > 0) {
                double smallContainerWeight = totalWeight / containerCount;

                if (smallContainerWeight <= 500) {
                    return containerCount * 1000.0;
                } else {
                    return containerCount * 1200.0;
                }
            } else {
                return 0.0;
            }
        }
        return 0.0;
    }

    //The printItem method to print item information
    public void printItemInfo() {
        Set<String> uniqueItems = new HashSet<>();
        for (Item item : items) {
            String itemName = item.getName();
            if (!uniqueItems.contains(itemName)) {
                item.printItemInfo();
                uniqueItems.add(itemName);
            }
        }
    }

    //The printOrder method to show order information and price
    public void printOrder() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int quantity = order.get(i);
            System.out.println(quantity + "x " + item.getName());
        }
        System.out.println("Total Shipping Price: " + calculateShippingPrice() + " Euro");
    }
}

