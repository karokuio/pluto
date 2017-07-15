package pluto.util

import org.yaml.snakeyaml.Yaml as SnakeYaml

/**
 * Utilities to deal with yaml files
 *
 * @since 0.1.0
 */
class Yaml {

  /**
   * Loads a given classpath resource, and creates an instance of the
   * desired class. The structure of the Yaml file should obey the
   * structure of the class.
   *
   * @param resource the resource we would like to load
   * @param class the class we want the yaml to be converted
   * @return an instance of the desired class
   * @since 0.1.0
   */
  static <T> T loadAs(String resource, Class<?> clazz) {
    final InputStream inputSt = Yaml.getResourceAsStream(resource)
    final SnakeYaml snakeYaml = new SnakeYaml()
    final Map map = snakeYaml.load(inputSt) as Map

    return clazz.newInstance(map)
  }
}
