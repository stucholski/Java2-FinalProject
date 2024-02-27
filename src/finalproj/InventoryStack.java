package finalproj;

public interface InventoryStack {

    /**
     * Return the remaining capacity of the bag
     * @return the remaining capacity of the inventory.
     */
    public float getRemainingCapacity();

    /**
     * Get specific item from inventory
     * @param itemName is the name of the inventory to look for in the inventory
     * @return returns an item if found.
     */
    public Item getItem(String itemName);

    /**
     * Stores specific item in the inventory
     * @param item to store in the inventory
     * @return a boolean flag
     */
    public boolean storeItem(Item item);

    /**
     * This method shows all items in the inventory.
     */
    public void showAllItems();

}


