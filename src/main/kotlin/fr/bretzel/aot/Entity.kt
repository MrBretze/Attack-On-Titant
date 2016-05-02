package fr.bretzel.aot

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.LeashHitch

class Entity {

    private var entity: LeashHitch = null!!

    private var locStart: Location = null!!
    private var locStop: Location = null!!

    private var distance: Double = locStart.distance(locStop)

    private var taskID: Int = 0

    constructor(world: World, start: Location, stop: Location) {
        this.locStart = start
        this.locStop = stop

        if (entity == null) {
            entity = world.spawn(start, LeashHitch::class.java)
        }

        taskID = Bukkit.getServer().scheduler.runTaskTimerAsynchronously(AOT.INSTANCE, Runnable {
            this.update()
        }, 0, 0).taskId
    }


    fun update() {
        if (distance >= 0) {
            distance = distance.minus(1)
            print(distance)
        } else {
            Bukkit.getScheduler().cancelTask(taskID)
        }
    }
}