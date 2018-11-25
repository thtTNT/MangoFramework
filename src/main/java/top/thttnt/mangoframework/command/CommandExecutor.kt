package top.thttnt.mangoframework.command

interface CommandExecutor {

    fun onCommand(label: String, cmd: String, args: Array<String>)
}