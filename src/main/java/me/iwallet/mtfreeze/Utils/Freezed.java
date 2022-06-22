package me.iwallet.mtfreeze.Utils;

import me.iwallet.mtfreeze.MTFreeze;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Freezed {
    private ArrayList<UUID> freezed = new ArrayList<>();

    private BossBar FreezedBar = Bukkit.createBossBar(Format.chat(MTFreeze.instance.getConfig().getString("bossbar")), BarColor.BLUE, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);

    public boolean isFreezed(Player player) {
        return this.freezed.contains(player.getUniqueId());
    }

    public void setFreezed(Player player) {
        UUID uuid = player.getUniqueId();
        if (!isFreezed(player))
            this.freezed.add(uuid);
        this.FreezedBar.addPlayer(player);
        Collection<? extends Player> onlinePlayers = MTFreeze.getInstance().getServer().getOnlinePlayers();
        for (Player onlinePlayer : onlinePlayers) {
            if (onlinePlayer.hasPermission(MTFreeze.instance.getConfig().getString("permission")));
        }
    }

    public void unsetFreezed(Player player) {
        UUID uuid = player.getUniqueId();
        if (isFreezed(player))
            this.freezed.remove(uuid);
        this.FreezedBar.removePlayer(player);
        Collection<? extends Player> onlinePlayers = MTFreeze.getInstance().getServer().getOnlinePlayers();
        for (Player onlinePlayer : onlinePlayers) {
            if (onlinePlayer.hasPermission(MTFreeze.instance.getConfig().getString("permission")));
        }
    }

    public void removefreezebar(Player player) {
        for (Player onlinepl : Bukkit.getOnlinePlayers()) {
            if (onlinepl.hasPermission(MTFreeze.instance.getConfig().getString("permission")) &&
                    MTFreeze.getFreezedUtil().isFreezed(onlinepl))
                this.FreezedBar.removePlayer(onlinepl);
        }
    }
}
