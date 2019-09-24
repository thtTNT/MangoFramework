package top.thttnt.mangoframework.configuration

import top.thttnt.mangoframework.plugin.MangoPlugin
import top.thttnt.mangoframework.plugin.PluginInfo
import java.io.File

object ConfigManager {

    private val dataFolder = File("config")

    fun init() {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs()
        }
    }

    fun getGlobalConfig(plugin: MangoPlugin, domain: String): FileConfiguration {
        val file = File(dataFolder,plugin.getName() + "_" + domain + ".yaml")
        return FileConfiguration.load(file)
    }

}