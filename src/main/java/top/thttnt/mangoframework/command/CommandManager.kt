package top.thttnt.mangoframework.command

import top.thttnt.mangoframework.MangoFramework
import java.util.*

object CommandManager {

    private val commandExecutors = TreeMap<String, CommandExecutor>()

    fun listen() {
        while (true) {
            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()
            handleCommand(line)
        }
    }

    fun getCommands(): MutableSet<String> {
        return commandExecutors.keys;
    }

    fun handleCommand(cmd: String) {
        var tmp = ""
        var label = ""
        var args = Array(0) { "" }
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
        if (!commandExecutors.containsKey(label)) {
            MangoFramework.logger.log("Command not found!")
        }
        commandExecutors.forEach { (key, executor) ->
            run {
                if (label == key) {
                    executor.onCommand(label, cmd, args)
                }
            }
        }
    }

    fun registerCommand(label: String, executor: CommandExecutor) {
        if (commandExecutors.containsKey(label)) {
            MangoFramework.logger.warn("Command $label has been registered twice. It might cause some problem")
        }
        this.commandExecutors[label] = executor
    }

}