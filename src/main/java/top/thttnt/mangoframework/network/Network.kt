package top.thttnt.mangoframework.network

import top.thttnt.mangoframework.Config
import top.thttnt.mangoframework.MangoFramework
import java.net.ServerSocket

object Network{

    lateinit var server : ServerSocket

    fun init(){
        val port = Config.Socket.port
        this.server = ServerSocket(port)
        MangoFramework.logger.log("The server is stared at port $port")
    }
}