package top.thttnt.mangoframework.network

import top.thttnt.mangoframework.Config
import top.thttnt.mangoframework.MangoFramework
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

object Network{

    lateinit var server : ServerSocket

    fun init(){
        val port = Config.Socket.port
        this.server = ServerSocket(port)
        object : Thread(){
            val socket = server.accept()

        }.start()
        MangoFramework.logger.log("The server is stared at port $port")
    }

}
