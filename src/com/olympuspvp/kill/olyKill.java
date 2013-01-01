package com.olympuspvp.kill;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class olyKill extends JavaPlugin{

	final String tag = ChatColor.DARK_RED + "[" + ChatColor.RED + "olyKill" + ChatColor.DARK_RED + "] " + ChatColor.RED;

	@Override
	public void onEnable(){
		System.out.println("[olyKill] olyKill by Medious has been enabled");
	}

	@Override
	public boolean onCommand(final CommandSender s, final Command cmd, final String c, final String[] args){
		if(s instanceof Player == false) return true;
		final Player p = (Player)s;
		if(args.length == 0){
			p.setHealth(0);
		}else if(args.length == 1 ){
			if(p.hasPermission("olyKill.use")== false){
				p.sendMessage(tag + "You do not have permission to use this");
				return true;
			}final String name = args[0];
			final Player kill = Bukkit.getPlayer(name);
			if (kill == null) p.sendMessage(tag + "Could not find player. ");
			else{
				kill.sendMessage(tag + "You were killed by " + ChatColor.DARK_RED + p.getName());
				p.sendMessage(tag + "You killed " + ChatColor.DARK_RED + kill.getName());
				kill.setHealth(0);
			}
		}return true;
	}

}
