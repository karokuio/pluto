package pluto.events

import javax.inject.Inject
import javax.inject.Provider
import net.jodah.lyra.util.Duration
import net.jodah.lyra.config.Config
import net.jodah.lyra.config.RetryPolicy
import net.jodah.lyra.config.RecoveryPolicies
import pluto.config.PlutoConfig

/**
 * @since 0.1.0
 */
class LyraConfigurationProvider implements Provider<Config> {

  /**
   * Access to Pluto message broker configuration
   *
   * @since 0.1.0
   */
  @Inject
  PlutoConfig config

  @Override
  Config get() {
    PlutoConfig.Retry retry = config.events.retry

    return new Config()
      .withRecoveryPolicy(RecoveryPolicies.recoverAlways())
      .withRetryPolicy(new RetryPolicy()
                       .withMaxAttempts(retry?.max_attempts ?: 20)
                       .withInterval(Duration.seconds(retry?.interval ?: 10))
                       .withMaxDuration(Duration.seconds(retry?.max_duration ?: 300)))
  }
}
