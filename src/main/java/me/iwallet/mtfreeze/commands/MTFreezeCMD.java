package me.iwallet.mtfreeze.commands;

import me.iwallet.mtfreeze.MTFreeze;
import me.iwallet.mtfreeze.Utils.Format;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MTFreezeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        Player p = (Player) sender;
        if (!p.hasPermission(MTFreeze.instance.getConfig().getString("permission"))) {
            p.sendMessage(MTFreeze.instance.getConfig().getString("geenpermission"));
            return false;
        }
        if (args.length < 1) {
            if (!p.hasPermission(MTFreeze.instance.getConfig().getString("permission"))) {
                SendHelp(p);
            }
        }
        return false;
    }
    public void SendHelp(Player p) {
        p.sendMessage(Format.chat("&8&m-------------------------"));
        p.sendMessage(Format.chat("&b&lMT&3&lFREEZE &8| &9v1"));
        p.sendMessage(Format.chat("&8&m-------------------------"));
        p.sendMessage(Format.chat(" "));
        p.sendMessage(Format.chat("&b/mtfreeze &8- &7Het helpcommando."));
        p.sendMessage(Format.chat("&b/freeze &8- &7Free/unfreeze een speler."));
        p.sendMessage(Format.chat(" "));
        p.sendMessage(Format.chat("&8&m-------------------------"));
    }
}