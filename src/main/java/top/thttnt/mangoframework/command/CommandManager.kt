package top.thttnt.mangoframework. command

import top.thttnt.mangoframework.MangoFramework
import top.thttnt.mangoframework.plugin.MangoPlugin
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object CommandManager {

    private val commandExecutors = HashMap<String, RegisterInfo>()

    fun listen() {
        while (true) {
            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()
            handleCommand(line)
        }
    }

    fun getCommands(): MutableSet<String> {
        return commandExecutors.keys
    }

    private fun handleCommand(cmd: String) {
        var tmp = ""
        var label = ""
        val args = Array(0) { "" }
        ("$cmd ").toCharArray().forEach {
            if (it == ' ') {
                if (tmp.isNotEmpty()) {
                    if (label.isEmpty()) {
                        label = tmp
                    } else {
                        args.plus(tmp)
                    }
                }
                tmp = ""
            } else {
                tmp += it
            }
        }
        execute(label, cmd, args)
    }

    fun execute(label: String, cmd: String, args: Array<String>) {
        if (!commandExecutors.containsKey(label) || !commandExecutors[label]!!.enable) {
            MangoFramework.logger.log("Command not found! Use command \"help\" for help")
        }
        commandExecutors.forEach { (key, info) ->
            run {
                if (label == key) {
                    info.executor.onCommand(label, cmd, args)
                }
            }
        }
    }

    fun registerCommand(label: String, executor: CommandExecutor, plugin: MangoPlugin) {
        if (commandExecutors.containsKey(label) && commandExecutors[label]!!.enable) {
            MangoFramework.logger.warn("Command $label has been registered twice. It might cause some problem")
        }
        this.commandExecutors[label] = RegisterInfo(plugin, executor)
    }

    fun unregisterCommand(plugin: MangoPlugin) {
        this.commandExecutors.forEach {
            if (it.value.plugin.getName() == plugin.getName()) {
                it.value.enable = false
            }
        }
    }

    class RegisterInfo(val plugin: MangoPlugin, val executor: CommandExecutor){
        var enable = true
    }

}