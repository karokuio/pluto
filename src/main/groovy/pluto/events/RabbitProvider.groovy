package pluto.events

import javax.inject.Provider
import javax.inject.Inject
import com.rabbitmq.client.Channel
import com.rabbitmq.client.ConnectionFactory
import net.jodah.lyra.config.Config
import net.jodah.lyra.Connections
import groovy.util.logging.Slf4j

/**
 * Initializes the RabbitMQ connection
 *
 * @since 0.1.0
 */
@Slf4j
class RabbitProvider implements Provider<Channel> {

  /**
   * General connection information
   *
   * @since 0.1.0
   */
  @Inject
  ConnectionFactory factory

  /**
   * Configuration on how the system should behave on a connection
   * resource failure
   *
   * @since 0.1.0
   */
  @Inject
  Config lyraConfig

  @Override
  Channel get() {
    return Connections.create(factory, lyraConfig).createChannel()
  }
}
