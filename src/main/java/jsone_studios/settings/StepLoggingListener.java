package jsone_studios.settings;

public interface StepLoggingListener extends StepProvider
{
    /**
     * Adds a {@link LoggingListener} to the Settings
     */
    StepProvider addLoggingListener(LoggingListener listener);
}
