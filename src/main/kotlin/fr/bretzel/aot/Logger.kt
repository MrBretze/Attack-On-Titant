package fr.bretzel.aot

import org.bukkit.Bukkit
import org.bukkit.ChatColor

class Logger {

    companion object {

        val debug: Boolean = false

        fun debug(obj: Object) {
            if (debug)
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED.toString() + "[DEBUG AOT]" + ChatColor.RESET.toString() + toString(obj))
        }

        fun debug(obj: String) {
            if (debug)
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED.toString() + "[DEBUG AOT]" + ChatColor.RESET.toString() + obj)
        }

        fun info(obj: Object) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + "[INFO AOT]" + ChatColor.RESET.toString() + toString(obj))
        }

        fun info(obj: String) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN.toString() + "[INFO AOT]" + ChatColor.RESET.toString() + obj)
        }

        private fun toString(obj: Object): String {
            return obj.toString()
        }

    }

}
