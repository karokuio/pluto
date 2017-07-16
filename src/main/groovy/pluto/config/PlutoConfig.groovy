package pluto.config

/**
 * Minimal configuration needed to work with Pluto
 *
 * @since 0.1.0
 */
class PlutoConfig {

  /**
   * Information related to the message broker
   *
   * @since 0.1.0
   */
  Events events

  /**
   * Docker connection details
   *
   * @since 0.1.0
   */
  Docker docker

  /**
   * Information required to connect to the message broker
   *
   * @since 0.1.0
   */
  static class Events {

    /**
     * Information related to consumers
     *
     * @since 0.1.0
     */
    Consume consume

    /**
     * Information related to publishers
     *
     * @since 0.1.0
     */
    Publish publish

    /**
     * Information related to broker connection details
     *
     * @since 0.1.0
     */
    Broker broker

    /**
     * Retry policy when something goes wrong in a message broker
     * resource
     *
     * @since 0.1.0
     */
    Retry retry

  }

  /**
   * Information required for consumers
   *
   * @since 0.1.0
   */
  static class Consume {

    /**
     * The queue the consumer will be listening to
     *
     * @since 0.1.0
     */
    String queue
  }

  /**
   * Information required to publish events
   *
   * @since 0.1.0
   */
  static class Publish {

    /**
     * Which exchange Pluto will be sending events to
     *
     * @since 0.1.0
     */
    String exchange
  }

  /**
   * Broker connection details
   *
   * @since 0.1.0
   */
  static class Broker {

    /**
     * Broker hostname
     *
     * @since 0.1.0
     */
    String host

    /**
     * Broker listening port
     *
     * @since 0.1.0
     */
    Integer port

    /**
     * Broker username credentials
     *
     * @since 0.1.0
     */
    String username

    /**
     * Broker password credentials
     *
     * @since 0.1.0
     */
    String password
  }

    /**
     * Information on how to recover from a message broker resource
     * failure
     *
     * @since 0.1.0
     */
    @SuppressWarnings('PropertyName')
    static class Retry {

      /**
       * Pause (in seconds) between attempts
       *
       * @since 0.1.0
       */
      Integer interval

      /**
       * The maximum number of attempts retrying
       *
       * @since 0.1.0
       */
      Integer max_attempts

      /**
       * The max duration to perform attempts for
       *
       * @since 0.1.0
       */
      Integer max_duration
    }

  /**
   * Docker connection details
   *
   * @since 0.1.0
   */
  static class Docker {

    /**
     * Complete uri where Docker will be listening to
     * (e.g. http://127.0.0.1:4243)
     *
     * @since 0.1.0
     */
    String uri
  }
}
