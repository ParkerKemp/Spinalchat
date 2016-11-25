package com.spinalcraft.spinalchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.dynmap.DynmapWebChatEvent;

import com.earth2me.essentials.Essentials;
import com.spinalcraft.skull.SpinalcraftPlugin;

public class Spinalchat extends SpinalcraftPlugin implements Listener{
	private Essentials ess;
	static ConsoleCommandSender console;
	
	@Override
	public void onEnable(){
		super.onEnable();
		console = Bukkit.getConsoleSender();
		
		getServer().getPluginManager().registerEvents((Listener)this,  this);

		ess = (Essentials)Bukkit.getServer().getPluginManager().getPlugin("Essentials");
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled=true)
	public void onDynmapWebChat(DynmapWebChatEvent event){
		if(ess.getUser(event.getName()).isMuted()){
			console.sendMessage(ChatColor.RED + "Spinalchat denied web message from muted player \"" + event.getName() + "\".");
			event.setCancelled(true);
		}
			
	}
	
	@Override
	public void onDisable(){
		
	}
}
