package jsone_studios.settings;

public interface StepProvider
{
    /**
     * Adds a {@link SettingsProvider} to the Settings object.
     *
     * A Settings object can contain more than just one SettingsProvider to allow chaining.
     */
    StepMoreProvider provider(SettingsProvider settingsProvider);
}
