package mc.carlton.freerpg.events.enchanting;

import mc.carlton.freerpg.gameTools.ExperienceBottleTracking;
import mc.carlton.freerpg.configStorage.ConfigLoad;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class ExperienceBottleBreak implements Listener {
    @EventHandler
    void onExpBottleBreak(ExpBottleEvent e){
        ConfigLoad configLoad = new ConfigLoad();
        if (!configLoad.isGetEXPFromEnchantingBottles()) {
            ExperienceBottleTracking experienceBottleTracking = new ExperienceBottleTracking();
            experienceBottleTracking.addLocation(e.getEntity().getLocation());
        }
    }
}
