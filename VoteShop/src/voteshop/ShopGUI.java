package voteshop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopGUI {
	
    public static ItemStack istack = new ItemStack(Material.DIAMOND_SWORD);
	public static ItemStack istack2 = new ItemStack(Material.DIAMOND_SWORD);
	public static ItemStack istack3 = new ItemStack(Material.GOLDEN_APPLE, VoteShop.GoldenApplesForTwoTokens);
	public static ItemStack istack4 = new ItemStack(Material.GOLDEN_APPLE, VoteShop.GodApplesForTwoTokens, (short) 1);
    public static ItemStack istack5 = new ItemStack(Material.NETHER_STAR);
    
	public static void shop(Player p) {
		Inventory inv = p.getPlayer().getServer().createInventory(null, 18, ChatColor.DARK_AQUA + "VoteShop");
		ItemMeta imeta = istack.getItemMeta();
		imeta.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
		imeta.addEnchant(Enchantment.DURABILITY, 10, true);
		imeta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
		imeta.setDisplayName(ChatColor.RED + "12 Credits");
		List<String> slot1 = new ArrayList<String>();
		slot1.add(ChatColor.RED + "A glimmering vote sword!");
		slot1.add(ChatColor.RED + "12 Credits");
		imeta.setLore(slot1);
		istack.setItemMeta(imeta);
		inv.addItem(istack);
		
		ItemMeta imeta2 = istack2.getItemMeta();
		imeta2.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
		imeta2.addEnchant(Enchantment.DURABILITY, 10, true);
		imeta2.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
		imeta2.addEnchant(Enchantment.KNOCKBACK, 2, false);
		imeta2.setDisplayName(ChatColor.RED + "16 Credits");
		List<String> slot2 = new ArrayList<String>();
		slot2.add(ChatColor.RED + "A god sword!");
		slot2.add(ChatColor.RED + "16 Credits");
		imeta2.setLore(slot2);
		istack2.setItemMeta(imeta2);
		
		ItemMeta imeta3 = istack3.getItemMeta();
		imeta3.setDisplayName(ChatColor.RED + "2 Credits");
		List<String> slot3 = new ArrayList<String>();
		slot3.add(ChatColor.RED + "Golden Apples!");
		slot3.add(ChatColor.RED + "2 Credits");
		imeta.setLore(slot3);
		istack.setItemMeta(imeta3);
		inv.addItem(istack3);
		
		ItemMeta imeta4 = istack4.getItemMeta();
		imeta4.setDisplayName(ChatColor.RED + "2 Credits");
		List<String> slot4 = new ArrayList<String>();
		slot4.add(ChatColor.RED + "God Apples!");
		slot4.add(ChatColor.RED + "2 Credits");
		imeta4.setLore(slot4);
		istack.setItemMeta(imeta4);
		inv.addItem(istack);
		
		ItemMeta imeta5 = istack3.getItemMeta();
		imeta5.setDisplayName(ChatColor.RED + "Your Tokens: " + VoteShop.voteData.get(p));
		List<String> slot5 = new ArrayList<String>();
		slot5.add(ChatColor.RED + "Your Tokens: " + VoteShop.voteData.get(p));
		imeta5.setLore(slot4);
		istack5.setItemMeta(imeta5);
        inv.addItem(istack);
        inv.addItem(istack2);
        inv.addItem(istack3);
        inv.addItem(istack4);
        p.getPlayer().openInventory(inv);
	}
}
