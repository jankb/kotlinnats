package net.polvott.kotlinnats

import io.nats.client.Nats
import io.nats.client.Options
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

        val credsFile = Nats.credentials("/home/jankb/Downloads/sample-dev-jankb.creds")
        val options = Options.Builder()
            .server("tls://connect.nats.mattilsynet.io:4222")
            .connectionName("kotlinnats")
            .authHandler(credsFile)
            .build()
        val nc = Nats.connect(options)
        nc.publish("jankbtest", protoSampe.toByteArray())
        nc.close()
    }
}