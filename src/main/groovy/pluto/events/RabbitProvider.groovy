package pluto.events

import javax.inject.Provider
import javax.inject.Inject
import groovy.util.logging.Slf4j
import com.rabbitmq.client.ConnectionFactory
import pluto.config.PlutoConfig

/**
 * Initializes the RabbitMQ connection
 *
 * @since 0.1.0
 */
@Slf4j
class RabbitProvider implements Provider<ConnectionFactory> {

  @Inject
  PlutoConfig config

  @Override
  ConnectionFactory get() {
    log.debug "initializing rabbit provider"

    PlutoConfig.Broker broker = config.events.broker
    ConnectionFactory factory = new ConnectionFactory()

    factory.setUsername(broker.username)
    factory.setPassword(broker.password)
    factory.setHost(broker.host)
    factory.setPort(broker.port)

    log.debug "rabbit provider complete"
    return factory
  }
}
