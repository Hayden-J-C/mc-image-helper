package me.itzg.helpers.http;

import me.itzg.helpers.http.SharedFetch.Options;
import picocli.CommandLine.Option;

import java.time.Duration;

/**
 * Usage:
 * <pre>
 * {@code
 *     @ArgGroup(exclusive = false)
 *     SharedFetchArgs sharedFetchArgs = new SharedFetchArgs();
 * }
 * </pre>
 */
public class SharedFetchArgs {

    private final Options.OptionsBuilder optionsBuilder = Options.builder();

    @Option(names = "--http-response-timeout", defaultValue = "${env:FETCH_RESPONSE_TIMEOUT:-PT30S}",
        description = "The response timeout to apply to HTTP operations. Parsed from ISO-8601 format. "
            + "Default: ${DEFAULT-VALUE}"
    )
    public void setResponseTimeout(Duration timeout) {
        optionsBuilder.responseTimeout(timeout);
    }

    @Option(names = "--tls-handshake-timeout", defaultValue = "${env:FETCH_TLS_HANDSHAKE_TIMEOUT:-PT30S}",
        description = "Default: ${DEFAULT-VALUE}"
    )
    public void setTlsHandshakeTimeout(Duration timeout) {
        optionsBuilder.tlsHandshakeTimeout(timeout);
    }

    @Option(names = "--connection-pool-max-idle-timeout", defaultValue = "${env:FETCH_CONNECTION_POOL_MAX_IDLE_TIMEOUT}")
    public void setConnectionPoolMaxIdleTimeout(Duration timeout) {
        optionsBuilder.maxIdleTimeout(timeout);
    }

    public Options options() {
        return optionsBuilder.build();
    }
}
