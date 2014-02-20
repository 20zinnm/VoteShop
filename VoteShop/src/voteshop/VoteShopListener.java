	package voteshop;
	
	import org.bukkit.Bukkit;
	import org.bukkit.ChatColor;
	import org.bukkit.entity.Player;
	import org.bukkit.event.Listener;
	import org.bukkit.event.inventory.InventoryClickEvent;
	import org.bukkit.inventory.Inventory;
	import org.bukkit.inventory.ItemStack;
	
	import com.vexsoftware.votifier.model.VotifierEvent;
	
	public class VoteShopListener implements Listener {
	
		public void onVotifierEvent(VotifierEvent e) {
			String pS = e.getVote().getUsername();
			Player p = Bukkit.getPlayer(pS);
			if (!VoteShop.voteData.containsKey(e.getVote().getUsername())) {
				VoteShop.voteData.put(p, 0);
			}
			Integer prevTokens = VoteShop.voteData.get(p);
			Integer newTokens = prevTokens + VoteShop.TokenIncrement;
			VoteShop.voteData.put(p, newTokens);
			p.sendMessage(ChatColor.DARK_BLUE + "Thanks for voting! You now have 4 more tokens! New Token balance: " + ChatColor.RED + newTokens);
			p.sendMessage(ChatColor.DARK_BLUE + "Use " + ChatColor.RED + "/voteshop" + ChatColor.DARK_BLUE + " to spend your tokens!");
		}
		
		public void onInventoryClickEvent(InventoryClickEvent e) {
			Inventory inv = e.getInventory();
			String pS = e.getWhoClicked().getName();
			Player p = Bukkit.getServer().getPlayer(pS);
			if (inv.getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "VoteShop")) {
				Integer tokens = VoteShop.voteData.get(p);
				ItemStack clickedOn = e.getCurrentItem();
				if (clickedOn.equals(ShopGUI.istack)) {
					e.setCancelled(true);
					if (tokens >= 12) {
						Integer newTokens = tokens - 12;
						VoteShop.voteData.put(p, newTokens);
						p.getInventory().addItem(ShopGUI.istack);
						p.sendMessage(ChatColor.DARK_BLUE + "You purchased a voteshop sword for 12 credits! New Balance:" + ChatColor.RED + newTokens);
						p.closeInventory();
					}
				}
				if (clickedOn.equals(ShopGUI.istack2)) {
					e.setCancelled(true);
					if (tokens >= 16) {
						Integer newTokens = tokens - 16;
						VoteShop.voteData.put(p, newTokens);
						p.getInventory().addItem(ShopGUI.istack2);
						p.sendMessage(ChatColor.DARK_BLUE + "You purchased a voteshop sword for 12 credits! New Balance:" + ChatColor.RED + newTokens);
						p.closeInventory();
					}
				}
				if (clickedOn.equals(ShopGUI.istack3)) {
					e.setCancelled(true);
					if (tokens >= VoteShop.GoldenApplesForTwoTokens) {
						Integer newTokens = tokens - VoteShop.GoldenApplesForTwoTokens;
						VoteShop.voteData.put(p, newTokens);
						p.getInventory().addItem(ShopGUI.istack3);
						p.sendMessage(ChatColor.DARK_BLUE + "You purchased" + VoteShop.GoldenApplesForTwoTokens + " golden apples for 2 credits! New Balance:" + ChatColor.RED + newTokens);
						p.closeInventory();
					}
				}
				if (clickedOn.equals(ShopGUI.istack4)) {
					e.setCancelled(true);
					if (tokens >= 12) {
						Integer newTokens = tokens - VoteShop.GoldenApplesForTwoTokens;
						VoteShop.voteData.put(p, newTokens);
						p.getInventory().addItem(ShopGUI.istack3);
						p.sendMessage(ChatColor.DARK_BLUE + "You purchased " + VoteShop.GodApplesForTwoTokens + " god apples for 2 credits! New Balance:" + ChatColor.RED + newTokens);
						p.closeInventory();
					} else {
						p.sendMessage("Not enough tokens! You need " + (VoteShop.GodApplesForTwoTokens - tokens) + " more tokens!");
					}
				}
			}
		}
		
	}
