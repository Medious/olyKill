package com.olympuspvp.kill;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class olyKill extends JavaPlugin{
	@Override
	public void onEnable(){
		System.out.println("[olyKill] olyKill by Medious has been enabled");
	}

	public boolean onCommand(CommandSender s, Command cmd, String c, String[] args){
		if (s instanceof Player == false) return true;
		Player p = (Player)s;
		if(args.length == 0){
			p.setHealth(0);
		}else if(args.length == 1 ){
			if (p.hasPermission("olyKill.use")== false){
				p.sendMessage("[olyKill] you do not have permission to use this");
				return true; 
			}
			String name = args[0];
			Player kill = Bukkit.getPlayer(name);
			if (kill == null) {
				p.sendMessage("[olyKill] Could not find player. ");
				
			}else {
				kill.sendMessage("[olyKill] You were killed by "+p.getName());
				p.sendMessage("[olyKill] you killed "+kill.getName());
				kill.setHealth(0);
			}
		}
		return true;
	}

}
