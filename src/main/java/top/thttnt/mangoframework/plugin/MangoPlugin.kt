package top.thttnt.mangoframework.plugin

import top.thttnt.mangoframework.log.Logger


open class MangoPlugin {

    private lateinit var logger: Logger

    private var enable = false

    fun getLogger(): Logger {
        return this.logger
    }

    open fun onEnable() {

    }
}