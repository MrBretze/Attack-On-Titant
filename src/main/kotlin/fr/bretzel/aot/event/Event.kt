package fr.bretzel.aot.event

import fr.bretzel.aot.Util
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class Event: Listener {

    @EventHandler
    fun onPlayerRightClick(event: PlayerInteractEvent) {

        var player: Player = event.player

        if (event.item != null && event.item.type == Material.LEASH) {
            val loc: Location = Util.getDestination(player, 100)
            player.teleport(loc)
        }
    }

}