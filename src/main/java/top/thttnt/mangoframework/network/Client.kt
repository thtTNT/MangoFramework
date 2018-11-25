package top.thttnt.mangoframework.network

import top.thttnt.mangoframework.event.EventManager
import top.thttnt.mangoframework.event.network.ClientConnectedEvent
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client(socket: Socket, id: Int) : Thread() {

    companion object {

        private var id = 1

        fun create(socket: Socket): Client {
            val client = Client(socket, id)
            val clientConnectedEvent = ClientConnectedEvent(client)
            EventManager.call(event = clientConnectedEvent)
            return client
        }
    }

    val br: BufferedReader
    val pw: PrintWriter

    init {
        br = BufferedReader(InputStreamReader(socket.getInputStream()))
        pw = PrintWriter(socket.getOutputStream())
    }

    override fun run() {
        while (true) {
            val line = br.readLine()
        }
    }
}