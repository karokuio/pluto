package pluto.events

import javax.inject.Inject
import groovy.util.logging.Slf4j
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.ConnectionFactory

/**
 * Consumes messages from the configured message queue
 *
 * @since 0.1.0
 */
@Slf4j
abstract class RabbitConsumer extends DefaultConsumer {

  /**
   * Receives a channel to get messages from
   *
   * @since 0.1.0
   */
  @Inject
  RabbitConsumer(ConnectionFactory factory) {
    super(factory.newConnection().createChannel())
  }
}
