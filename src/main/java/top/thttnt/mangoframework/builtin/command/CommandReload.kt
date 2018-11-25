package top.thttnt.mangoframework.builtin.command

import top.thttnt.mangoframework.builtin.Mango
import top.thttnt.mangoframework.command.CommandExecutor
import top.thttnt.mangoframework.plugin.PluginManager

class CommandReload : CommandExecutor {

    override fun onCommand(label: String, cmd: String, args: Array<String>) {
        PluginManager.unloadAllPlugins()
        PluginManager.loadAll()
        Mango.logger.log("All plugins has been reloaded.")
    }

}