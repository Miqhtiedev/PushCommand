package miqhtie.push;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class InteractEvent implements Listener {
    @EventHandler
    public void interact(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            PushItem pItem = new PushItem();
            if(!pItem.isItem(event.getPlayer().getInventory().getItemInMainHand())) return;
            Player player = event.getPlayer();
            player.setVelocity(player.getLocation().getDirection().setY(player.getLocation().getDirection().getBlockY() + 2).add(new Vector(2,0,0)).multiply(50));
            player.getWorld().strikeLightning(player.getLocation());
        }
    }
}
