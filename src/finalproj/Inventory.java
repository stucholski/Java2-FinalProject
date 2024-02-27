package finalproj;


/**
 * This class is used to create all types of inventories in the game.
 */
public abstract class Inventory implements InventoryStack{

    @Override
    public float getRemainingCapacity() {
        return 0;
    }

    @Override
    public Item getItem(String itemName) {
        return null;
    }

    @Override
    public boolean storeItem(Item item) {
        return true;
    }

    @Override
    public void showAllItems() {

    }
}