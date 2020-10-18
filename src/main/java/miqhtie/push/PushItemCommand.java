package miqhtie.push;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PushItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String permission = "push.getitem";
        if(!sender.hasPermission(permission)) {
            sender.sendMessage(String.format("%sMissing Permission %s", ChatColor.RED, permission));
            return true;
        }
        if(!(sender instanceof Player)){
            sender.sendMessage(String.format("%sError: You are robot", ChatColor.RED));
            return true;
        }

        PushItem item = new PushItem();
        ((Player) sender).getInventory().addItem(item.item());

        return false;
    }
}

