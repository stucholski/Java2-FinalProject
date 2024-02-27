package finalproj;


/**
 * Specific inventory for the player.
 */
public class PlayerInventory extends Inventory{

    private final Item[] items = new Item[100]; // number of items you can store in the inventory

    private final int MAX_LIMIT; // total weight you can store in the inventory

    private final String name;

    /**
     * Initializes the player inventory
     * @param maxLimit is the weight capacity of the inventory
     * @param inventoryName name of the user's inventory. Used in conversations around the game.
     */
    PlayerInventory(int maxLimit, String inventoryName){
        items[0] = Item.Knife;
        items[1] = Item.Plate;
        MAX_LIMIT = maxLimit;
        name = inventoryName;
    }

    @Override
    public float getRemainingCapacity() {

        float currentWeight = 0;

        for (int i=0; i<items.length; i++){
            if(items[i] != null){
                currentWeight += items[i].getWeight();
            }
        }

        return MAX_LIMIT - currentWeight;
    }


    @Override
    public Item getItem(String itemName) {

        // This section should loop through all items and return the item if found
        Item item = null;

        for (int i=0; i<items.length; i++){

            if(items[i] != null &&  items[i].name().toLowerCase().equals(itemName)){
                System.out.println( "Got Item " + items[i].name().toLowerCase() + " out of the bag.");

                for(Item currentItem: Item.values()){
                    if(currentItem.name().toLowerCase().equals(itemName)){
                        item = currentItem;
                        break;
                    }
                }

                items[i] = null;
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean storeItem(Item item) {
        // Compare new item's weight with inventory capacity
        if(getRemainingCapacity() > item.getWeight()){

            for (int i=0; i<items.length; i++){
                if(items[i] == null){
                    items[i] = item;

                    // let user know the item was stored
                    return  true;
                }
            }
        }
        return false;
    }

    @Override
    public void showAllItems() {

        System.out.println("Current items in inventory");
        for (int i=0; i<items.length; i++){
            if(items[i] != null){
                System.out.println(items[i].name());
            }
        }
    }
}
