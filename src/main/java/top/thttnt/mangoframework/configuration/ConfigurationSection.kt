package top.thttnt.mangoframework.configuration

@Suppress("UNCHECKED_CAST")
open class ConfigurationSection(private val map: HashMap<String, Any>) {

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

    fun getSection(key: String): ConfigurationSection? {
        return if (contain(key) && this.map[key] is HashMap<*, *>) {
            ConfigurationSection(this.map[key] as HashMap<String, Any>)
        } else {
            null
        }
    }
}
