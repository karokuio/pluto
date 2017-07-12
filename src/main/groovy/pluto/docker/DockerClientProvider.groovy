package pluto.docker

import javax.inject.Provider
import javax.inject.Inject
import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.core.DockerClientBuilder

import pluto.config.PlutoConfig

/**
 * Provides a connection with the configured Docker instance via a
 * {@link DockerClient} instance
 *
 * @since 0.1.0
 */
class DockerClientProvider implements Provider<DockerClient> {

  /**
   * Pluto's configuration. Required to know Docker connection details
   *
   * @since 0.1.0
   */
  @Inject
  PlutoConfig config

  @Override
  DockerClient get() {
    return DockerClientBuilder
      .getInstance(config.docker.uri)
      .build()
  }
}
