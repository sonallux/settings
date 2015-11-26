package jsone_studios.settings;

public class LogHandler
{
    private static LoggingListener loggingListener;

    static void setLoggingListener(LoggingListener listener)
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
