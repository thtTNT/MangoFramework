package top.thttnt.mangoframework.event.network

import top.thttnt.mangoframework.event.Event
import top.thttnt.mangoframework.network.Client

class ClientConnectedEvent(client: Client) : ClientEvent(client) {

}