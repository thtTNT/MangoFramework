package top.thttnt.mangoframework.event.network

import top.thttnt.mangoframework.event.Event
import top.thttnt.mangoframework.network.Client

open class ClientEvent(private val client: Client) : Event {

    fun getClient(): Client {
        return this.client
    }

}