package fr.bretzel.aot.config

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class Config {

    private var config: FileConfiguration? = null
    private var file: File? = null;

    constructor(file: File?) {

        if (!file!!.exists()) {
            throw IllegalArgumentException("The file is not created !")
        }

        this.file = file;
        config = YamlConfiguration.loadConfiguration(file)
    }

    fun getValue(value: String, default: Any): Any {

        if (config!!.contains(value)) {
            return config!!.get(value)
        }

        (config as FileConfiguration).set(value, default)

        return default;
    }

    fun getConfig(): FileConfiguration {
        return config!!;
    }

    fun saveConfig() {
        config!!.save(file)
    }
}