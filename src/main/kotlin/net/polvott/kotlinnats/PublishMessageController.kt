package net.polvott.kotlinnats

import io.nats.client.Nats
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PublishMessageController {
    @GetMapping("/publish/{message}")
    fun publishMessage(@PathVariable message: String) {
        val protoSampe = SampleOuterClass.Sample.newBuilder()
            .setMTid("MTid")
            .setMTsampnt("MTsampnt")
            .setMTmessage(message)
            .build()

        val nc = Nats.connect("nats://localhost:4222")
        nc.publish("proveta.nats.test", protoSampe.toByteArray())
        nc.close()
    }
}