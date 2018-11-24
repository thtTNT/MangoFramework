package top.thttnt.mangoframework.log

import java.text.SimpleDateFormat

class Logger(private val name: String) {

    fun getName(): String {
        return this.name
    }

    fun log(msg: String) {
        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(System.currentTimeMillis())
        System.out.println("[$time][INFO][$name]$msg")
    }

    fun warn(msg: String) {
        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(System.currentTimeMillis())
        System.out.println("[$time][WARN][$name]$msg")
    }

    fun error(msg: String) {
        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(System.currentTimeMillis())
        System.out.println("[$time][ERROR][$name]$msg")
    }
}