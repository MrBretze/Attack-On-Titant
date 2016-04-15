package fr.bretzel.aot

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class AOT: JavaPlugin() {



    companion object {

        @JvmField var INSTANCE: AOT? = null
        @JvmField var CONFIG: FileConfiguration? = null

    }

    override fun onLoad() {
        Logger.debug("Attack of the titans plugin starting of loading !")
        INSTANCE = this

    }

    override fun onEnable() {

        val f: File = File(dataFolder, "config.yml")

        if (!f.exists()) {

            if (!dataFolder.exists()) {
                dataFolder.mkdir()
            }

            f.createNewFile()
        }

        CONFIG = YamlConfiguration.loadConfiguration(f)

    }

    override fun onDisable() {

    }
}