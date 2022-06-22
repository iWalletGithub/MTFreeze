package me.iwallet.mtfreeze.listeners;

import me.iwallet.mtfreeze.MTFreeze;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;


public class FreezeListener implements Listener {

    @EventHandler
    public void WalkEvent(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (MTFreeze.getFreezedUtil().isFreezed(p)) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void OnInvClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (MTFreeze.getFreezedUtil().isFreezed(p)) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void PlayerSwapEvent(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        if (MTFreeze.getFreezedUtil().isFreezed(p)) {
            e.setCancelled(true);
        } else {
            return;
        }
    }
}
