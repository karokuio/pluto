package pluto.events

import com.google.inject.Scopes
import com.google.inject.AbstractModule
import com.rabbitmq.client.ConnectionFactory

/**
 * Module responsible for loading message broker connection and
 * publishing client
 *
 * @since 0.1.0
 */
class Module extends AbstractModule {
  @Override
  void configure() {
    bind(ConnectionFactory).toProvider(RabbitProvider).in(Scopes.SINGLETON)
    bind(Publisher).to(RabbitPublisher).in(Scopes.SINGLETON)
  }
}
