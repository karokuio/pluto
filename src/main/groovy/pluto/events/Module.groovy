package pluto.events

import com.google.inject.Scopes
import com.google.inject.AbstractModule
import com.rabbitmq.client.Channel
import com.rabbitmq.client.ConnectionFactory
import net.jodah.lyra.config.Config

/**
 * Module responsible for loading message broker connection and
 * publishing client
 *
 * @since 0.1.0
 */
class Module extends AbstractModule {
  @Override
  void configure() {
    bind(ConnectionFactory).toProvider(ConnectionFactoryProvider).in(Scopes.SINGLETON)
    bind(Config).toProvider(LyraConfigurationProvider).in(Scopes.SINGLETON)
    bind(Channel).toProvider(RabbitProvider)
    bind(Publisher).to(RabbitPublisher).in(Scopes.SINGLETON)
  }
}
