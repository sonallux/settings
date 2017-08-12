package jsone_studios.settings;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the core functionality of the library.
 */
@SuppressWarnings("unused")
public class Settings
{
    private List<SettingsProvider> settingsProviders;

    Settings(SettingsBuilder builder)
    {
        this.settingsProviders = new ArrayList<>(builder.providerList);
    }

    private <T> String getValueAsString(SettingsKey<T> key)
    {
        for (SettingsProvider provider : settingsProviders)
        {
            String value = provider.getValue(key.getKey());
            if (value != null)
            {
                return value;
            }
        }
        return key.asString(key.getDefaultValue());
    }

    /**
     * Get the value for this SettingsKey
     *
     * @param key the SettingsKey
     * @param <T> the type of the SettingsKey and therefore also of the return value
     * @return the value
     */
    public <T> T get(SettingsKey<T> key)
    {
        return key.parseValue(getValueAsString(key));
    }

    /**
     * Checks if a value for the SettingsKey exists in any of the SettingsProviders
     *
     * @param key the SettingsKey
     * @return true if at least one SettingsProvider has a value for this SettingsKey, false otherwise
     */
    public boolean hasValue(SettingsKey key)
    {
        return settingsProviders.stream().anyMatch(settingsProvider -> settingsProvider.hasValue(key.getKey()));
    }

    /**
     * Creates a new SettingsEditor to edit the Settings
     *
     * @return the new SettingsEditor
     */
    public SettingsEditor edit()
    {
        return new SettingsEditor(this);
    }

    void put(SettingsKey key, String value)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.put(key.getKey(), value));
    }

    void delete(SettingsKey key)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.delete(key.getKey()));
    }

    void save()
    {
        settingsProviders.forEach(SettingsProvider::save);
    }
}
