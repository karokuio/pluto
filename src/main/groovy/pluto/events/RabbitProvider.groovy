package pluto.events

import javax.inject.Provider
import javax.inject.Inject
import groovy.util.logging.Slf4j
import com.rabbitmq.client.Channel
import com.rabbitmq.client.ConnectionFactory
import pluto.config.PlutoConfig
import net.jodah.lyra.util.Duration
import net.jodah.lyra.config.Config
import net.jodah.lyra.config.RetryPolicy
import net.jodah.lyra.config.RecoveryPolicies
import net.jodah.lyra.Connections

/**
 * Initializes the RabbitMQ connection
 *
 * @since 0.1.0
 */
@Slf4j
class RabbitProvider implements Provider<Channel> {

  @Inject
  PlutoConfig config

  @Override
  Channel get() {
    log.debug "initializing rabbit provider"
    PlutoConfig.Broker broker = config.events.broker
    PlutoConfig.Retry retry = config.events.retry

    ConnectionFactory factory = new ConnectionFactory()
    factory.setUsername(broker.username)
    factory.setPassword(broker.password)
    factory.setHost(broker.host)
    factory.setPort(broker.port)

    Config lyraConfig = new Config()
      .withRecoveryPolicy(RecoveryPolicies.recoverAlways())
      .withRetryPolicy(new RetryPolicy()
                       .withMaxAttempts(retry.max_attempts ?: 20)
                       .withInterval(Duration.seconds(retry.interval ?: 10))
                       .withMaxDuration(Duration.seconds(retry.max_duration ?: 300)))

    log.debug "rabbit provider complete"
    return Connections.create(factory, lyraConfig).createChannel()
  }
}
