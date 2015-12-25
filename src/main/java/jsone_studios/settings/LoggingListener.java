package jsone_studios.settings;

/**
 * A listener for logging events, so apps using this library can use their own logging framework.
 */
public interface LoggingListener
{
    /**
     * Log a message which an Throwable
     *
     * @param tag the logging tag
     * @param msg a describing message
     * @param t the Throwable
     */
    void error(String tag, String msg, Throwable t);

    /**
     * Log a message
     *
     * @param tag the logging tag
     * @param msg the message
     */
    void warn(String tag, String msg);
}
