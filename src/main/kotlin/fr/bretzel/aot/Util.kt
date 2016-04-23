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

            var loop: Int = 0;

            while (loop < maxDistance) {

                loop = loop.plus(1)

                f.add(progress)

                print("loop: " + loop)

                if (f.block.type.isSolid) {
                    return f
                }
            }
            return f;
        }
    }
}