package top.thttnt.mangoframework

import top.thttnt.mangoframework.log.Logger
import java.io.File
import java.io.FileOutputStream

object MangoFramework {

    val logger = Logger("MAIN")


    fun start(args: Array<String>) {
        logger.log("MangoFramework is made for built your custom server. We are still working on it, so it maybe unstable. Thank for your supporting. ")
        logger.log("MangoFramework is starting...")
        Config.init()
    }
}

object Config {

    fun init() {
        val file = File("config.yml")
        if (!file.exists()){
            MangoFramework.logger.log("Config file doesn't exist. Create one by default.")
            val fis = this.javaClass.classLoader.getResourceAsStream("config.yml")
            val bs = ByteArray(fis.available())
            fis.read(bs)
            val fos = FileOutputStream(file)
            fos.write(bs)
            fos.close()
        }

    }
}

fun main(args: Array<String>) {
    MangoFramework.start(args)
}
