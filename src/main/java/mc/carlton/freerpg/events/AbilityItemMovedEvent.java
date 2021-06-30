package mc.carlton.freerpg.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

/*
 * This event constitutes multiple event in the case that an ability item is moved
 */
public class AbilityItemMovedEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private Event event;
    private Player player;
    private ItemStack abilityItem;

    private AbilityItemMovedEvent(ItemStack abilityItem, Event event) {
        this.event = event;
        this.abilityItem = abilityItem;
        if (event instanceof Cancellable) {
            this.cancelled = ((Cancellable) event).isCancelled();
        }
    }

    /**
     * Class constructor
     * @param event InventoryClickEvent
     * @param abilityItem Item that has active ability on it
     */
    public AbilityItemMovedEvent(InventoryClickEvent event, ItemStack abilityItem) {
        this(abilityItem,event);
        this.player = (Player) event.getWhoClicked();
    }
    /**
     * Class constructor
     * @param event InventoryDragEvent
     * @param abilityItem Item that has active ability on it
     */
    public AbilityItemMovedEvent(InventoryDragEvent event, ItemStack abilityItem) {
        this(abilityItem,event);
        this.player = (Player) event.getWhoClicked();
    }
    /**
     * Class constructor
     * @param event FrpgPlayerRightClickEvent
     * @param abilityItem Item that has active ability on it
     */
    public AbilityItemMovedEvent(PlayerRightClickEvent event, ItemStack abilityItem) {
        this(abilityItem,event);
        this.player = event.getPlayer();
    }

    /**
     * Class constructor
     * @param event FrpgPlayerRightClickEvent
     * @param abilityItem Item that has active ability on it
     */
    public AbilityItemMovedEvent(PlayerInteractEntityEvent event, ItemStack abilityItem) {
        this(abilityItem,event);
        this.player = event.getPlayer();
    }

    /**
     * Getter for the player
     * @return Player who moved the ability item
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * getter for abilityItem
     * @return The resulting itemstack that is an ability item
     */
    public ItemStack getAbilityItem() {
        return abilityItem;
    }

    /**
     * Getter for cancelled
     * @return true if the associated event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Setter for cancelled, also cancels the event
     * @param cancel true if the event is to be cancelled
     */
    @Override
    public void setCancelled(boolean cancel) {
        if (event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(cancel);
        }
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
