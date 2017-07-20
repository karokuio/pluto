package pluto.events

import groovy.util.logging.Slf4j
import javax.inject.Inject
import javax.inject.Provider
import pluto.config.PlutoConfig
import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

/**
 * Provides instances of {@link ConnectionFactory}
 *
 * @since 0.1.0
 */
@Slf4j
class ConnectionFactoryProvider implements Provider<ConnectionFactory> {

  /**
   * Access to Pluto message broker configuration
   *
   * @since 0.1.0
   */
  @Inject
  PlutoConfig config

  @Override
  ConnectionFactory get() {
    PlutoConfig.Broker broker = config.events.broker

    log.debug "creating connection factory"
    ConnectionFactory factory = new ConnectionFactory()
    factory.setUsername(broker.username)
    factory.setPassword(broker.password)
    factory.setHost(broker.host)
    factory.setPort(broker.port)

    log.debug "creating connection and channel"
    Connection connection = factory.newConnection()
    Channel channel = connection.createChannel()

    log.debug "declaring queue"
    channel.queueDeclareNoWait(config.events.consume.queue, false, false, false, null)

    log.debug "closing channel and connection"
    channel.close()
    connection.close()

    return factory
  }
}
