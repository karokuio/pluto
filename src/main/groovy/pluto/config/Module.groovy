package pluto.config

import com.google.inject.Scopes
import com.google.inject.AbstractModule

/**
 * Module responsible for loading Pluto's related configuration
 *
 * @since 0.1.0
 */
class Module extends AbstractModule {
  @Override
  void configure() {
    bind(PlutoConfig)
      .toProvider(PlutoConfigProvider)
      .in(Scopes.SINGLETON)
  }
}
