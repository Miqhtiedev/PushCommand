package miqhtie.push;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PushCommand implements CommandExecutor {

    private Main plugin;
    public PushCommand(Main main){
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String permission = "push.use";
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(ChatColor.RED + "Missing permission " + permission);
            return true;
        }


        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "INVALID COMMAND USAGE ): | Ex /push (playername)");
            return true;
        }


        Player player = Bukkit.getPlayer(args[0]);
        if(player == null){
            sender.sendMessage(ChatColor.RED + "NO PLAYER FOUND WITH NAME " + args[0]);
            return true;
        }

        player.setVelocity(player.getLocation().getDirection().multiply(-50));
        player.getWorld().strikeLightning(player.getLocation());
        sender.sendMessage(ChatColor.GREEN + "Pushed " + args[0]);
        return false;
    }
}
