package top.thttnt.mangoframework.configuration

import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream

class FileConfiguration(private val map: HashMap<String, Any>) {

    companion object {
        fun load(file: File): FileConfiguration {
            if (!file.exists()) {
                return FileConfiguration(HashMap())
            }
            val fis = FileInputStream(file)
            val yaml = Yaml()
            val map = yaml.load(fis)
            return FileConfiguration(map as HashMap<String, Any>)
        }
    }

    fun contain(key: String): Boolean {
        return map.containsKey(key)
    }

    fun get(key: String): Any? {
        return this.map[key]
    }

    fun set(key: String, value: Any) {
        this.map[key] = value
    }

    fun getInt(key: String): Int? {
        return if (contain(key) && this.map[key] is Int) {
            this.map[key] as Int
        } else {
            0
        }
    }

    fun getSection(key: String): FileConfiguration? {
        return if (contain(key) && this.map[key] is HashMap<*, *>) {
            FileConfiguration(this.map[key] as HashMap<String, Any>)
        } else {
            null
        }
    }

}