package pluto.events

import javax.inject.Inject
import groovy.util.logging.Slf4j
import com.rabbitmq.client.Channel
import com.rabbitmq.client.DefaultConsumer

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
   * @param channel the channel required to consume messages from
   * @since 0.1.0
   */
  @Inject
  RabbitConsumer(final Channel channel) {
    super(channel)
  }
}
