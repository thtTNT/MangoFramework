package top.thttnt.mangoframework.event

import kotlin.reflect.KClass

annotation class EventHandler(val type: KClass<*>)