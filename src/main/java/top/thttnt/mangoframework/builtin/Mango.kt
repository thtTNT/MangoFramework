package top.thttnt.mangoframework.builtin

import top.thttnt.mangoframework.builtin.command.CommandHelp
import top.thttnt.mangoframework.builtin.command.CommandReload
import top.thttnt.mangoframework.builtin.command.CommandStop
import top.thttnt.mangoframework.command.CommandManager
import top.thttnt.mangoframework.log.Logger
import top.thttnt.mangoframework.plugin.MangoPlugin
import top.thttnt.mangoframework.plugin.PluginInfo

@PluginInfo(name = "Mango")
class Mango : MangoPlugin() {

    companion object {
        lateinit var logger: Logger
    }

    override fun onEnable() {
        logger = this.getLogger()
        CommandManager.registerCommand("help", CommandHelp(),this)
        CommandManager.registerCommand("stop", CommandStop(),this)
        CommandManager.registerCommand("reload", CommandReload(),this)
        getLogger().log("Mango built-in plugin has been loaded successfully")
    }
}