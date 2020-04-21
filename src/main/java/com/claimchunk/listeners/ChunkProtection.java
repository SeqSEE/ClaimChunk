package com.claimchunk.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.level.particle.FlameParticle;
import com.claimchunk.Database;
import com.claimchunk.Loader;

public class ChunkProtection implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onBlockPlace(BlockPlaceEvent e) throws Exception {
		if(!Loader.config.getBoolean("claimProtection.build")) {
			return;
		}
        Player p = e.getPlayer();
        if (Database.getClaimOwner(e.getBlock()) != null && !(p.getName().equalsIgnoreCase(Database.getClaimOwner(e.getBlock())))) {
            if(Database.isGranted(Database.getClaimId(e.getBlock()), e.getPlayer().getUniqueId())) {
                for(int i = 0; i < 15; i++) p.getLevel().addParticle(new FlameParticle(e.getBlock().getLocation()));
                p.sendTitle("§6§lClaimChunk","§cThis area is claimed");
                e.setCancelled(true);
            }
        }
    }

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onBlockBreak(BlockBreakEvent e) throws Exception {
    	if(!Loader.config.getBoolean("claimProtection.build")) {
			return;
		}
        Player p = e.getPlayer();
        if (Database.getClaimOwner(e.getBlock()) != null && !(p.getName().equalsIgnoreCase(Database.getClaimOwner(e.getBlock())))) {
            if(Database.isGranted(Database.getClaimId(e.getBlock()), e.getPlayer().getUniqueId())) {
                for(int i = 0; i < 15; i++) p.getLevel().addParticle(new FlameParticle(e.getBlock().getLocation()));
                p.sendTitle("§6§lClaimChunk","§cThis area is claimed");
                e.setCancelled(true);
            }
        }
    }
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onInteract(PlayerInteractEvent e) throws Exception {
    	if(!Loader.config.getBoolean("claimProtection.interact")) {
			return;
		}
        Player p = e.getPlayer();
        if (Database.getClaimOwner(e.getBlock()) != null && !(p.getName().equalsIgnoreCase(Database.getClaimOwner(e.getBlock())))) {
            if(Database.isGranted(Database.getClaimId(e.getBlock()), e.getPlayer().getUniqueId())) {
                for(int i = 0; i < 15; i++) p.getLevel().addParticle(new FlameParticle(e.getBlock().getLocation()));
                p.sendTitle("§6§lClaimChunk","§cThis area is claimed");
                e.setCancelled(true);
            }
        }
    }
    
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onEntityDamage(EntityDamageEvent e) throws Exception {
    	if(!Loader.config.getBoolean("claimProtection.entityDamage")) {
			return;
		}
        if(e.getEntity() instanceof Player) {
            Player p = (Player)e.getEntity();
            if (Database.getClaimOwner(p) != null) {
                for (int i = 0; i < 15; i++) p.getLevel().addParticle(new FlameParticle(p.getLocation()));
                p.sendTip("§cDamage disabled in claim");
                e.setCancelled(true);
            }
        }
    }
}
