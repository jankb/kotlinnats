package net.polvott.kotlinnats

import io.nats.client.Nats
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PublishMessageController {
    @GetMapping("/publish/{message}")
    fun publishMessage(@PathVariable message: String) {
        val nc = Nats.connect("nats://localhost:4222")
        nc.publish("proveta.nats.test", message.toByteArray())
        nc.close()
    }
}