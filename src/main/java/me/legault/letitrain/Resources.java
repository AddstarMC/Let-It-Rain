package me.legault.letitrain;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Resources {
	
	public static final ChatColor msgColor = ChatColor.AQUA;
	
	public static String getPluginTitle(){
		return LetItRain.plugin.getDescription().getFullName();
	}

	@SuppressWarnings("deprecation")
	public static EntityType getEntityType(String identifier){
		EntityType e;
		try{
			int i = Integer.parseInt(identifier);
			try{
				e = EntityType.fromId(i);
			}catch(Exception f){
				return null;
			}
		}catch(Exception f){
			try{
				e = EntityType.fromName(identifier);
			}catch(Exception g){
				return null;
			}
		}
		
		if (e.isSpawnable())
			return e;
		return null;
	}
	
	public static void broadcast(String msg){
		LetItRain.server.broadcastMessage(msgColor + ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	public static void privateMsg(CommandSender sender, String msg){
		if (sender != null){
			if (sender instanceof Player)
				((Player)sender).sendMessage(msgColor + ChatColor.translateAlternateColorCodes('&', msg));
			else
				sender.sendMessage(msg);
		}
				
	}
	
	public static Player isPlayer(String s){
		if (s == null)
			return null;
		
		Player player = LetItRain.server.getPlayer(s);
		
		return player;	
	}
}
