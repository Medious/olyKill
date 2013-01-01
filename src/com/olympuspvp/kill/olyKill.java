package com.olympuspvp.kill;

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
		}
		return true;
	}

}
