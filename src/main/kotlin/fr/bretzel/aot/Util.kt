package fr.bretzel.aot

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Giant
import org.bukkit.entity.Player
import org.bukkit.util.Vector

class Util {

    companion object {

        fun getDestination(player: Player, range: Int): Location {

            val playerEyes: Location = player.eyeLocation
            val direction: Vector = playerEyes.direction.normalize()
            val f: Location = playerEyes.clone()
            val progress: Vector = direction.clone().multiply(0.5)
            val maxDistance: Int = 100 * range / 70

            var loop: Int = 0

            while (loop < maxDistance) {

                loop = loop.plus(1)

                f.add(progress)
                
                if (f.world.getNearbyEntities(f, 0.5, 0.5, 0.5).size > 0) {
                    val it: MutableCollection<Entity> = f.world.getNearbyEntities(f, 0.5, 0.5, 0.5)
                    val iterator: Iterator<Entity> = it.iterator()

                    while (iterator.hasNext()) {
                        val ent: Entity = iterator.next()

                        if (ent is Giant)
                            return f
                    }
                }

                if (f.block.type.isSolid)
                    return f

            }
            return f
        }


        fun movePlayerToPoint(player: Player, stop: Location, vector: Vector) {

            while (player.location.distanceSquared(stop) > 2) {
                player.velocity = vector.multiply(player.location.distance(stop))
            }

        }
    }
}