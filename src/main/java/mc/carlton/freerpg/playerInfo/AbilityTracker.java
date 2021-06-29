package mc.carlton.freerpg.playerInfo;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbilityTracker {
    private Player player;
    private UUID uuid;
    static Map<UUID, Integer[]> playerAbilities = new HashMap<UUID, Integer[]>();

    public AbilityTracker(Player p) {
        this.player = p;
        this.uuid = player.getUniqueId();
    }

    public Integer[] getPlayerAbilities() {
        if (!playerAbilities.containsKey(uuid)) {
            Integer[] initAbilities = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            playerAbilities.put(uuid,initAbilities);
        }
        return playerAbilities.get(uuid);
    }
    public Map<UUID, Integer[]> getAbilities() {
        if (!playerAbilities.containsKey(uuid)) {
            Integer[] initAbilitiess = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            playerAbilities.put(uuid,initAbilitiess);
        }
        return playerAbilities;
    }

    public void setPlayerAbility(String ability,int taskID) {
        if (!playerAbilities.containsKey(uuid)) {
            return;
        }
        Integer[] pAbilities = playerAbilities.get(uuid);
        switch(ability) {
            case "digging":
                pAbilities[0] = taskID;
                break;
            case "woodcutting":
                pAbilities[1] = taskID;
                break;
            case "mining":
                pAbilities[2] = taskID;
                break;
            case "farming":
                pAbilities[3] = taskID;
                break;
            case "fishing":
                pAbilities[4] = taskID;
                break;
            case "archery":
                pAbilities[5] = taskID;
                break;
            case "beastMastery":
                pAbilities[6] = taskID;
                break;
            case "swordsmanship":
                pAbilities[7] = taskID;
                break;
            case "defense":
                pAbilities[8] = taskID;
                break;
            case "axeMastery":
                pAbilities[9] = taskID;
                break;
            case "woodcuttingHaste":
                pAbilities[10] = taskID;
                break;
            case "diggingToggle":
                pAbilities[11] = taskID;
                break;
            case "archeryCrossbow":
                pAbilities[12] = taskID;
                break;
            case "swordsSpeed":
                pAbilities[13] = taskID;
                break;
            case "swordsStrength":
                pAbilities[14] = taskID;
                break;
            default:
                break;
        }
        playerAbilities.put(uuid, pAbilities);
    }

    public int getPlayerAbility(String ability) {
        if (!playerAbilities.containsKey(uuid)) {
            Integer[] initAbilities = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            playerAbilities.put(uuid,initAbilities);
        }
        Integer[] pAbilities = playerAbilities.get(uuid);
        switch(ability) {
            case "digging":
                return pAbilities[0];
            case "woodcutting":
                return pAbilities[1];
            case "mining":
                return pAbilities[2];
            case "farming":
                return pAbilities[3];
            case "fishing":
                return pAbilities[4];
            case "archery":
                return pAbilities[5];
            case "beastMastery":
                return pAbilities[6];
            case "swordsmanship":
                return pAbilities[7];
            case "defense":
                return pAbilities[8];
            case "axeMastery":
                return pAbilities[9];
            case "woodcuttingHaste":
                return pAbilities[10];
            case "diggingToggle":
                return pAbilities[11];
            case "archeryCrossbow":
                return pAbilities[12];
            case "swordsSpeed":
                return pAbilities[13];
            case "swordsStrength":
                return pAbilities[14];
            default:
                return -1;
        }
    }

    public void setAbilities(Map<UUID, Integer[]> abilities) {
        this.playerAbilities = abilities;
    }
    public void removePlayer() {
        playerAbilities.remove(uuid);
    }


}
