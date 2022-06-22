package me.iwallet.mtfreeze.commands;

import me.iwallet.mtfreeze.MTFreeze;
import me.iwallet.mtfreeze.Utils.Format;
import me.iwallet.mtfreeze.Utils.Freezed;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            Player freeze = Bukkit.getPlayer(args[0]);
            if (freeze.hasPlayedBefore()) {
                if (freeze.isOnline()) {
                    if (!p.hasPermission(MTFreeze.instance.getConfig().getString("permission"))) {
                        p.sendMessage(Format.chat(MTFreeze.instance.getConfig().getString("geenpermission")));
                    }
                    Freezed freezeUtil = MTFreeze.getFreezedUtil();
                    if (!freezeUtil.isFreezed(freeze)) {
                        freezeUtil.setFreezed(freeze);
                        p.sendMessage(Format.chat("&9&lMT&b&lFREEZE &8➟ &3Je hebt de speler &b" + freeze.getName() + " &3gefreezed"));
                        freeze.sendMessage(Format.chat("&9&lMT&b&lFREEZE &3➟ &3Je ben gefreezed door &b" + p.getName()));
                    } else {
                        freezeUtil.unsetFreezed(p);
                        p.sendMessage(Format.chat("&9&lMT&b&lFREEZE &8➟ &3Je hebt de speler &b" + freeze.getName() + " &3geunfreezed"));
                        freeze.sendMessage(Format.chat("&9&lMT&b&lFREEZE &8➟ &3Je ben geunfreezed door &b" + p.getName()));
                        return false;
                    }
                } else {
                    p.sendMessage(Format.chat("&cDie speler is niet online"));
                }
            } else {
                p.sendMessage(Format.chat("&cDeze speler is nog nooit online geweest.."));
            }
        } else {
            p.sendMessage(Format.chat("&cJe moet een speler meegeven!"));
        }
        return false;
    }
}