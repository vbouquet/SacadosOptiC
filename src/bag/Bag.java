package bag;

import java.util.HashMap;
import java.util.Map;


public class Bag {
    private double maxWeight;
    private Map<Integer, Item> items;
    private double weight;
    private double util;

    public Bag(double maxWeight) throws Exception {
        if (maxWeight < 0)
            throw new Exception(String.format("bag can't have negative maxWeight value : %s", maxWeight));
        this.maxWeight = maxWeight;
        items = new HashMap<>();
        util = 0;
    }

    public double getMaxWeight() {
        return this.maxWeight;
    }

    public double getUtiliy() {
        return util;
    }

    public boolean addItem(Item item) {
        if (items.containsKey(item.getNum()) || weight + item.getWeight() > maxWeight)
            return false;
        weight += item.getWeight();
        util += item.getUtil();
        items.put(item.getNum(), item);
        return true;
    }

    public int getNbItem() {
        return items.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sac : ");
        for (Item item : items.values())
            sb.append(item.toString()).append("\n");
        return sb.toString();
    }
}