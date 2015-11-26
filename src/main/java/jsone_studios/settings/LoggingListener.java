package jsone_studios.settings;

public interface LoggingListener
{
    void error(String tag, String msg, Throwable t);
    void warn(String tag, String msg);
}
