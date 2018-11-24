package top.thttnt.mangoframework

import top.thttnt.mangoframework.configuration.FileConfiguration
import top.thttnt.mangoframework.log.Logger
import top.thttnt.mangoframework.network.Network
import java.io.File
import java.io.FileOutputStream

object MangoFramework {

    val logger = Logger("MAIN")


    fun start(args: Array<String>) {
        val start = System.currentTimeMillis()
        logger.log("MangoFramework is starting...")
        Config.init()
        Network.init()
        logger.log("MangoFramework is made for built your custom server. We are still working on it, so it maybe unstable. Thank for your supporting. ")
        logger.log("Done!(time: ${(System.currentTimeMillis() - start).toDouble()/1000}s)")
    }
}

object Config {

    object Socket{
        var port = 12001

        fun init(config: FileConfiguration){
            val section = config.getSection("socket")
            port = section?.getInt("port") ?: 12001
        }
    }

    fun init() {
        MangoFramework.logger.log("Loading config...")
        val file = File("config.yml")
        if (!file.exists()) {
            MangoFramework.logger.log("Config file doesn't exist. Create one by default.")
            val fis = this.javaClass.classLoader.getResourceAsStream("config.yml")
            val bs = ByteArray(fis.available())
            fis.read(bs)
            val fos = FileOutputStream(file)
            fos.write(bs)
            fos.close()
        }
        val config = FileConfiguration.load(file)
        Socket.init(config)
    }
}

fun main(args: Array<String>) {
    MangoFramework.start(args)
}
