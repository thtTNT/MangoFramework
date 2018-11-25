package top.thttnt.mangoframework.builtin.command

import top.thttnt.mangoframework.builtin.Mango
import top.thttnt.mangoframework.command.CommandExecutor
import top.thttnt.mangoframework.command.CommandManager

class CommandHelp : CommandExecutor {

    override fun onCommand(label: String, cmd: String, args: Array<String>) {
        Mango.logger.log("Command you can use:")
        CommandManager.getCommands().forEach {
            Mango.logger.log(" - $it")
        }
    }

}