package pluto.docker

import com.google.inject.Scopes
import com.google.inject.AbstractModule
import com.github.dockerjava.api.DockerClient

/**
 * Module responsible to load the Docker client instance
 *
 * @since 0.1.0
 */
class Module extends AbstractModule {
  @Override
  void configure() {
    bind(DockerClient)
      .toProvider(DockerClientProvider)
      .in(Scopes.SINGLETON)
  }
}
