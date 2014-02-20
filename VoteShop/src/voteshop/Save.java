package voteshop;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Save {
	public static void save(HashMap<Player, Integer> map, String path) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(VoteShop.voteData);
			oos.flush();
			oos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				if (p.isOp()) {
					ItemStack is = new ItemStack(Material.DIAMOND, 1);
					p.setItemInHand(is);
					ItemMeta im = p.getItemInHand().getItemMeta();
					im.setDisplayName(ChatColor.RED + "Sorry about the error! --VoteShop");
				}
			}
		}
	}
}
