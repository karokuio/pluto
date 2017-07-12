package pluto.util

import org.junit.Test
import pluto.config.PlutoConfig

class YamlTests extends GroovyTestCase {

  @Test
  void testLoadPlutoConfig() {
    PlutoConfig config = Yaml.loadAs("pluto.yaml", PlutoConfig)

    assert config.events.broker.username == 'guest'
  }
}
