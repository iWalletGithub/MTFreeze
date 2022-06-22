package me.iwallet.mtfreeze;

import me.iwallet.mtfreeze.Utils.Format;
import me.iwallet.mtfreeze.Utils.Freezed;
import me.iwallet.mtfreeze.commands.FreezeCommand;
import me.iwallet.mtfreeze.commands.MTFreezeCMD;
import me.iwallet.mtfreeze.listeners.FreezeListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MTFreeze extends JavaPlugin {

    public static MTFreeze instance;
    private static Freezed freezed;

    public static MTFreeze getInstance() {
        return instance;
    }

    public static Freezed getFreezedUtil() {
        return freezed;
    }

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;
        freezed = new Freezed();


        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9[MTFREEZE] &7By iWallet"));
        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9███╗░░░███╗████████╗███████╗██████╗░███████╗███████╗███████╗███████╗"));
        System.out.println(Format.chat("&9████╗░████║╚══██╔══╝██╔════╝██╔══██╗██╔════╝██╔════╝╚════██║██╔════╝"));
        System.out.println(Format.chat("&9██╔████╔██║░░░██║░░░█████╗░░██████╔╝█████╗░░█████╗░░░░███╔═╝█████╗░░"));
        System.out.println(Format.chat("&9██║╚██╔╝██║░░░██║░░░██╔══╝░░██╔══██╗██╔══╝░░██╔══╝░░██╔══╝░░██╔══╝░░"));
        System.out.println(Format.chat("&9██║░╚═╝░██║░░░██║░░░██║░░░░░██║░░██║███████╗███████╗███████╗███████╗"));
        System.out.println(Format.chat("&9╚═╝░░░░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝░░╚═╝╚══════╝╚══════╝╚══════╝╚══════╝"));
        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9[MTFREEZE] &7Is succesvol geladen!"));

        getCommand("mtfreeze").setExecutor((CommandExecutor) new MTFreezeCMD());
        getCommand("freeze").setExecutor((CommandExecutor) new FreezeCommand());

        getServer().getPluginManager().registerEvents((Listener)new FreezeListener(), (Plugin)this);
    }

    @Override
    public void onDisable() {
        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9[MTFREEZE] &7By iWallet"));
        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9███╗░░░███╗████████╗███████╗██████╗░███████╗███████╗███████╗███████╗"));
        System.out.println(Format.chat("&9████╗░████║╚══██╔══╝██╔════╝██╔══██╗██╔════╝██╔════╝╚════██║██╔════╝"));
        System.out.println(Format.chat("&9██╔████╔██║░░░██║░░░█████╗░░██████╔╝█████╗░░█████╗░░░░███╔═╝█████╗░░"));
        System.out.println(Format.chat("&9██║╚██╔╝██║░░░██║░░░██╔══╝░░██╔══██╗██╔══╝░░██╔══╝░░██╔══╝░░██╔══╝░░"));
        System.out.println(Format.chat("&9██║░╚═╝░██║░░░██║░░░██║░░░░░██║░░██║███████╗███████╗███████╗███████╗"));
        System.out.println(Format.chat("&9╚═╝░░░░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝░░╚═╝╚══════╝╚══════╝╚══════╝╚══════╝"));
        System.out.println(Format.chat(""));
        System.out.println(Format.chat("&9[MTFREEZE] &7Is succesvol uitgeschakelt!"));
    }
}