package fr.bretzel.aot

import fr.bretzel.aot.config.Config
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class AOT: JavaPlugin() {

    companion object {

        @JvmField var INSTANCE: AOT? = null
        @JvmField var CONFIG: Config? = null

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

        CONFIG = Config(f)

    }

    override fun onDisable() {
        CONFIG!!.saveConfig()
    }
}