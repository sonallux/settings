package jsone_studios.settings.providers;

import jsone_studios.settings.SettingsProvider;

/**
 * A read only SettingsProvider which prohibits changes the underling SettingsProvider
 */
public class ReadOnlyProvider implements SettingsProvider
{
    private SettingsProvider delegate;

    /**
     * Constructs a new read only SettingsProvider, which does not allow changes to the given SettingsProvider
     * @param delegate the SettingsProvider which should be read only
     */
    public ReadOnlyProvider(SettingsProvider delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public void save()
    {
        //We are a ReadOnlyProvider so do not save changes
    }

    @Override
    public String getValue(String key)
    {
        return delegate.getValue(key);
    }

    @Override
    public boolean hasValue(String key)
    {
        return delegate.hasValue(key);
    }

    @Override
    public void put(String key, String value)
    {
        //We are a ReadOnlyProvider so do not make changes
    }

    @Override
    public void delete(String key)
    {
        //We are a ReadOnlyProvider so do not make changes
    }
}
