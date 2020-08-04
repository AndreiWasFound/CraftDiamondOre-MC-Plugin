package andreiwasfound.craftdiamondore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadConfig implements CommandExecutor {

    private final Main main;
    public ReloadConfig(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("craftdiamondore")) {
            if (!sender.hasPermission("craftdiamondore.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /craftdiamondore reload");
                return true;
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("craftdiamondore.reload")) {
                    main.reloadConfig();
                    sender.sendMessage(ChatColor.RED + "CraftDiamondOre config has been reloaded");
                    main.printToConsole(ChatColor.RED + "CraftDiamondOre config has been reloaded");
                    return true;
                    }
                }
            }
        }
        return false;
    }
}
