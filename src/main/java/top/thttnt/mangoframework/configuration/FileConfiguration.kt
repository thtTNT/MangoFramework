package top.thttnt.mangoframework.configuration

import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintWriter

@Suppress("UNCHECKED_CAST")
class FileConfiguration(private val map: HashMap<String, Any>, val file: File) : ConfigurationSection(map) {

    companion object {
        fun load(file: File): FileConfiguration {
            if (!file.exists()) {
                return FileConfiguration(HashMap(), file)
            }
            val fis = FileInputStream(file)
            val yaml = Yaml()
            val map = yaml.load(fis)
            return FileConfiguration(map as HashMap<String, Any>, file)
        }
    }

    fun save() {
        saveTo(file)
    }

    fun saveTo(to: File){
        val yaml = Yaml()
        val str = yaml.dump(map)
        val pw = PrintWriter(FileOutputStream(to))
        to.delete()
        pw.println(str)
        pw.close()
    }
}