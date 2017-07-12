package pluto.events

import javax.inject.Inject
import groovy.json.JsonOutput
import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import pluto.config.PlutoConfig

/**
 * Rabbit implementation of an {@link Publisher}
 *
 * @since 0.1.0
 */
class RabbitPublisher implements Publisher {

  @Inject
  PlutoConfig configuration

  @Inject
  ConnectionFactory factory

  @Override
  void publish(String topic, Serializable payload) {
    Connection conn = factory.newConnection()
    Channel channel = conn.createChannel()

    try {

      byte[] messageBytes = JsonOutput.toJson(payload).bytes
      channel.basicPublish(configuration.events.publish.exchange, topic, null, messageBytes)

    } finally {
      channel.close()
      conn.close()
    }
  }
}
