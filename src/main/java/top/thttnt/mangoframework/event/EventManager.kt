package top.thttnt.mangoframework.event

object EventManager {

    private val listeners = ArrayList<Any>()

    fun call(event: Event) {
        listeners.forEach { listener ->
            listener.javaClass.methods.filter {
                it.isAnnotationPresent(EventHandler::class.java)
            }.forEach {
                val eventHandler = it.getAnnotation(EventHandler::class.java)
                if (eventHandler.type.java.isAssignableFrom(event.javaClass)) {
                    it.invoke(listener, event)
                }
            }
        }
    }

    fun addListeners(listener: Any) {
        listeners.add(listener)
    }
}