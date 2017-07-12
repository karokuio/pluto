package pluto

import groovy.util.logging.Slf4j
import javax.inject.Inject
import com.google.inject.Guice
import pluto.config.PlutoConfig
import pluto.events.RabbitConsumer

/**
 * Pluto's entry point
 *
 * @since 0.1.0
 */
@Slf4j
class PlutoApplication {

  @Inject
  RabbitConsumer consumer

  @Inject
  PlutoConfig config

  /**
   * Bootstraps the application
   *
   * @since 0.1.0
   */
  void run() {
    log.debug "Pluto is listening to the '${config.events.consume.queue}' queue"
    consumer.channel.basicConsume(config.events.consume.queue, true, consumer)
  }

  /**
   * Application's main entry point
   *
   * @param args command line arguments
   * @since 0.1.0
   */
  static void main(args) {
    Guice.createInjector(new Module()).getInstance(PlutoApplication).run()
  }
}
