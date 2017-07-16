package pluto.events

import javax.inject.Inject
import javax.inject.Provider
import pluto.config.PlutoConfig
import com.rabbitmq.client.ConnectionFactory

/**
 * Provides instances of {@link ConnectionFactory}
 *
 * @since 0.1.0
 */
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

    ConnectionFactory factory = new ConnectionFactory()
    factory.setUsername(broker.username)
    factory.setPassword(broker.password)
    factory.setHost(broker.host)
    factory.setPort(broker.port)

    return factory
  }
}
