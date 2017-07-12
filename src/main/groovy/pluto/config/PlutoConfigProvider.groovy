package pluto.config

import javax.inject.Provider
import pluto.util.Yaml

/**
 * Loads Pluto's configuration
 *
 * @since 0.1.0
 */
class PlutoConfigProvider implements Provider<PlutoConfig> {

  @Override
  PlutoConfig get() {
    return Yaml.loadAs("pluto.yaml", PlutoConfig)
  }
}
