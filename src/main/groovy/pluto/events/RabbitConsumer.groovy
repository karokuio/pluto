package pluto.events

import javax.inject.Inject
import groovy.util.logging.Slf4j
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.ConnectionFactory

import com.github.dockerjava.api.DockerClient

/**
 * Consumes messages from the configured message queue
 *
 * @since 0.1.0
 */
@Slf4j
abstract class RabbitConsumer extends DefaultConsumer {

  final DockerClient client

  /**
   * Receives a channel to get messages from
   *
   * @since 0.1.0
   */
  @Inject
  RabbitConsumer(ConnectionFactory factory, DockerClient client) {
    super(factory.newConnection().createChannel())
    this.client = client
  }
}
