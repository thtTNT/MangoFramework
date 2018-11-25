package top.thttnt.mangoframework.plugin

import top.thttnt.mangoframework.MangoFramework
import top.thttnt.mangoframework.log.Logger
import java.io.File
import java.net.URLClassLoader
import java.util.jar.JarFile

object PluginManager {

    private val plugins = ArrayList<MangoPlugin>()

    fun loadAll() {
        MangoFramework.logger.log("Loading plugins...")
        val pluginDic = File("plugins")
        if (!pluginDic.exists()) {
            pluginDic.mkdirs()
        }
        val pluginFiles = pluginDic.listFiles()
        pluginFiles.forEach {
            if (it.extension != "jar") {
                return
            }
            val jarFile = JarFile(it)
            val url = it.toURI().toURL()
            val loader = URLClassLoader(arrayOf(url))
            val es = jarFile.entries()
            while (es.hasMoreElements()) {
                val jarEntry = es.nextElement()
                val name = jarEntry.name
                if (name != null && name.endsWith(".class", false)) {
                    val clazz = loader.loadClass(name.replace("/", ".").substring(0, name.length - 6))
                    if (clazz.isAnnotationPresent(PluginInfo::class.java) && MangoPlugin::class.java.isAssignableFrom(clazz)) {
                        addPlugin(clazz)
                    }
                }
            }
        }
        MangoFramework.logger.log("detect ${plugins.size} plugins.")
        enableAllPlugin()
    }

    private fun addPlugin(clazz: Class<*>) {
        this.plugins.add(clazz.newInstance() as MangoPlugin)
    }

    private fun enableAllPlugin() {
        val clazz = MangoPlugin::class.java
        val loggerField = clazz.getDeclaredField("logger")
        loggerField.isAccessible = true
        val enableField = clazz.getDeclaredField("enable")
        enableField.isAccessible = true
        plugins.forEach {
            val info = it.javaClass.getAnnotation(PluginInfo::class.java) as PluginInfo
            MangoFramework.logger.log("Loading plugin ${info.name}...")
            loggerField.set(it, Logger(info.name))
            enableField.set(it, true)
            it.onEnable()
        }
    }


}