package top.thttnt.mangoframework

import top.thttnt.mangoframework.command.CommandManager
import top.thttnt.mangoframework.configuration.ConfigManager
import top.thttnt.mangoframework.configuration.FileConfiguration
import top.thttnt.mangoframework.log.Logger
import top.thttnt.mangoframework.plugin.PluginManager
import java.io.File
import java.io.FileOutputStream
import kotlin.system.exitProcess

object MangoFramework {

    val logger = Logger("MAIN")


    fun start(args: Array<String>) {
        val start = System.currentTimeMillis()
        logger.log("MangoFramework is starting...")
        ConfigManager.init()
        PluginManager.loadAll()
        logger.log("MangoFramework is made for built your custom server. We are still working on it, so it maybe unstable. Thank for your supporting. ")
        logger.log("Done!(time: ${(System.currentTimeMillis() - start).toDouble() / 1000}s)")
        CommandManager.listen()
    }

    fun shutdown() {
        logger.log("MangoFramework is stopping...")
        logger.log("Unloading plugins...")
        PluginManager.unloadAllPlugins()
        logger.log("MangoFramework has been stopped!")
        exitProcess(0)
    }
}

//object Config {
//
//    fun init() {
//        MangoFramework.logger.log("Loading config...")
//        val file = File("config.yml")
//        if (!file.exists()) {
//            MangoFramework.logger.log("Config file doesn't exist. Create one by default.")
//            val fis = this.javaClass.classLoader.getResourceAsStream("config.yml")
//            val bs = ByteArray(fis.available())
//            fis.read(bs)
//            val fos = FileOutputStream(file)
//            fos.write(bs)
//            fos.close()
//        }
//        val config = FileConfiguration.load(file)
//    }
//}

fun main(args: Array<String>) {
    MangoFramework.start(args)
}
