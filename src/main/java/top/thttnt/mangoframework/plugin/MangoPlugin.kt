package top.thttnt.mangoframework.plugin

import top.thttnt.mangoframework.log.Logger

open class MangoPlugin {

    private lateinit var logger: Logger

    private var enable = false

    private var name = ""

    fun getLogger(): Logger {
        return this.logger
    }

    fun getName(): String {
        return this.name
    }

    open fun onEnable() {

    }

    open fun onDisable() {

    }
}