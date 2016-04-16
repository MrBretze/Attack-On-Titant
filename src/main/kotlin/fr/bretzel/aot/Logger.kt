package fr.bretzel.aot

import org.bukkit.Bukkit
import org.bukkit.ChatColor

class Logger {

    companion object {

        val debug: Boolean = false

        fun debug(obj: Any) {
            if (debug)
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED.toString() + "[DEBUG AOT]" + ChatColor.RESET.toString() + toString(obj))
        }

        fun info(obj: Any) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + "[INFO AOT]" + ChatColor.RESET.toString() + toString(obj))
        }

        private fun toString(obj: Any): String {
            return obj.toString()
        }

    }

}
