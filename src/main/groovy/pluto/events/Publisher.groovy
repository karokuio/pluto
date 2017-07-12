package pluto.events

/**
 * Defines how to send events
 *
 * @since 0.1.0
 */
interface Publisher {

  /**
   * Publishes a specific type of event
   *
   * @param topic namespace defining the event type
   * @param payload the event payload
   * @since 0.1.0
   */
  void publish(String topic, Serializable payload)
}
