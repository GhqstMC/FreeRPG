package mc.carlton.freerpg.events.enchanting;

import mc.carlton.freerpg.configStorage.ConfigLoad;
import mc.carlton.freerpg.playerInfo.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;

import java.util.ArrayList;
import java.util.Map;

public class PrepareRepair implements Listener {
    @EventHandler
    void onRepairOpen(PrepareAnvilEvent e){
        ConfigLoad configLoad = new ConfigLoad();
        if (!configLoad.getAllowedSkillsMap().get("enchanting")) {
            return;
        }
        AnvilInventory anvil = e.getInventory();
        try {
            Player p = (Player) anvil.getViewers().get(0);
            PlayerStats pStatClass = new PlayerStats(p);
            Map<String, ArrayList<Number>> pStat = pStatClass.getPlayerData();
            int levelSubtract = (int) pStat.get("enchanting").get(7);
            int newCost = Math.max(2,anvil.getRepairCost()-levelSubtract);
            anvil.setRepairCost(newCost);
        }
        catch (IndexOutOfBoundsException error){
            return;
        }


    }
}
