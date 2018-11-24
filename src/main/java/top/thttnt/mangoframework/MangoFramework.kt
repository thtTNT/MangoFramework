package top.thttnt.mangoframework

import top.thttnt.mangoframework.log.Logger

object MangoFramework {

    private val logger = Logger("MAIN")

    fun start(args: Array<String>) {
        logger.log("MangoFramework is made for built your custom server. We are still working on it, so it maybe unstable. Thank for your supporting. ")
        logger.log("MangoFramework is starting...")
    }
}

fun main(args: Array<String>) {
    MangoFramework.start(args)
}
