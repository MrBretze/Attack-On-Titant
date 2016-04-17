package fr.bretzel.aot

import org.bukkit.Location
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

            val loop: Int = maxDistance;

            while (loop > 0) {
                loop.minus(1)

                f.add(progress)

                if (f.block.type.isSolid) {
                    return f
                }
            }

            return null!!
        }



    }
}