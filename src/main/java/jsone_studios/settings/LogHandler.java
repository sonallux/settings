package jsone_studios.settings;

/**
 * This class handles logging for the settings library. A custom LoggingListener can be set with {@link #setLoggingListener(LoggingListener)}.
 * If a LoggingListener is set, all logging events are delegated to it, otherwise the events will be print to <code>System.err</code>.
 */
public class LogHandler
{
    private static LoggingListener loggingListener;

    public static void setLoggingListener(LoggingListener listener)
    {
        loggingListener = listener;
    }

    public static void error(String tag, String msg, Throwable t)
    {
        if (loggingListener == null)
        {
            System.err.println(tag + " | " + msg);
            t.printStackTrace();
        }
        else
        {
            loggingListener.error(tag, msg, t);
        }
    }

    public static void warn(String tag, String msg)
    {
        if (loggingListener == null)
        {
            System.err.println(tag + " | " + msg);
        }
        else
        {
            loggingListener.warn(tag, msg);
        }
    }
}
