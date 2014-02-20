package voteshop;
	
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
	
	public class Save {
		public static void save(HashMap<Player, Integer> map, String path)
		{
			try
			{
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
				oos.writeObject(map);
				oos.flush();
				oos.close();
			}
			catch(Exception e)
			{
				Bukkit.getServer().getLogger().warning("SPAM INCOMMING!!!");
				e.printStackTrace();
			}
		}
	}
