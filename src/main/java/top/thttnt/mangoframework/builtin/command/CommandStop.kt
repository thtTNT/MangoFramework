package top.thttnt.mangoframework.builtin.command

import top.thttnt.mangoframework.MangoFramework
import top.thttnt.mangoframework.command.CommandExecutor

class CommandStop : CommandExecutor {

    override fun onCommand(label: String, cmd: String, args: Array<String>) {
        MangoFramework.shutdown()
    }

}