package pluto

import com.google.inject.Scopes
import com.google.inject.AbstractModule

import pluto.docker.Module as DOCKER
import pluto.events.Module as EVENTS
import pluto.config.Module as CONFIG

/**
 * This module loads all required modules to bootstrap a Pluto's
 * application
 *
 * @since 0.1.0
 */
class Module extends AbstractModule {
  @Override
  void configure() {
    install(new DOCKER())
    install(new EVENTS())
    install(new CONFIG())

    bind(PlutoApplication).in(Scopes.SINGLETON)
  }
}
