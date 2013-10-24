package me.inspire.hat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public Main plugin;

	public void onEnable() {

	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;

		if (args.length == 1) {
			if (args[0].equals("list")) {
				player.sendMessage("List of blocks:"
						+ getConfig().getStringList("blocks").toString().trim());
			} else if (args[0].equalsIgnoreCase("off")) {
				player.getInventory().setHelmet(null);
			} else {

				try {

					Material mat = Material.getMaterial(args[0].toUpperCase());

					ItemStack block = new ItemStack(mat);

					if (!(block == null)) {
						if (player.hasPermission("InspireHats." + args[0])) {
							player.getInventory().setHelmet(block);
							player.sendMessage(ChatColor.DARK_BLUE + "["
									+ ChatColor.GOLD + "Inspire Hats"
									+ ChatColor.DARK_BLUE + "] "
									+ ChatColor.RED + "Enjoy your new "
									+ ChatColor.GREEN + args[0] + ChatColor.RED
									+ " hat");
							System.out.println("arg:" + args[0]);
						}
					}

				} catch (Exception e) {
					player.sendMessage("Unable to find block: " + args[0]
							+ ". Type '/hat list' for a list of block names!");
				}
			}
		}
		return false;
	}

}
