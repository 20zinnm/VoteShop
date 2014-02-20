	package voteshop;
	
	import java.io.File;
	import java.io.IOException;
	import java.util.HashMap;
	
	import org.bukkit.ChatColor;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandSender;
	import org.bukkit.entity.Player;
	import org.bukkit.plugin.java.JavaPlugin;
	
	public class VoteShop extends JavaPlugin {
	
		public static Integer TokensPerVote;
		public static Integer GodApplesForTwoTokens;
		public static Integer GoldenApplesForTwoTokens;
		public static Integer TokenIncrement;
		public static HashMap<Player, Integer> voteData = new HashMap<Player, Integer>();
		
		public void onEnable() {
			saveDefaultConfig();
			saveConfig();
			String path = getDataFolder() + File.separator + "votedata";
			File file = new File(path);
			if (!file.exists()) {
				getLogger().info("Missing data folder! Making a new one.");
				try {
					file.createNewFile();
				} catch (IOException e) {
					getLogger().info("Intimidating spam alert! Please report these errors on BukkitDev!");
					e.printStackTrace();
				}
			}
			Load.load(path);
			TokensPerVote = getConfig().getInt("TokensPerVote");
			GodApplesForTwoTokens = getConfig().getInt("GodApplesForTwoTokens");
			GoldenApplesForTwoTokens = getConfig().getInt("GoldenApplesForTwoTokens");
			TokenIncrement = getConfig().getInt("TokensPerVote");
	 		getLogger().info("VoteShop v0.1 enabled!");
		}
		public void onDisable() {
			String path = getDataFolder() + File.separator + "votedata";
			Save.save(voteData, path);
			getLogger().info("VoteShop disabled.");
		}
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_BLUE + "Only players can use this command!");
				return true;
		}
			if (!(args.length < 1)) {
				sender.sendMessage(ChatColor.DARK_BLUE + "TMA! (Too many arguments!)");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("voteshop")) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.DARK_BLUE + "Opening the shop!");
				ShopGUI.shop(p);
				return true;
			}
			return false;
		}
		
	}
