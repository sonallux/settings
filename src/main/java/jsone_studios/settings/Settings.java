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

    private <T> String getValueAsString(SettingsElement<T> element)
    {
        for (SettingsProvider provider : settingsProviders)
        {
            String value = provider.getValue(element.getKey());
            if (value != null)
            {
                return value;
            }
        }
        return element.asString(element.getDefaultValue());
    }

    /**
     * Get the value for this SettingsElement
     *
     * @param element the SettingsElement
     * @param <T> the type of the SettingsElement and therefore also of the return value
     * @return the value
     */
    public <T> T get(SettingsElement<T> element)
    {
        return element.parseValue(getValueAsString(element));
    }

    /**
     * Checks if a value for the SettingsElement exists in any of the SettingsProviders
     *
     * @param element the SettingsElement
     * @return true if at least one SettingsProvider has a value for this SettingsElement, false otherwise
     */
    public boolean hasValue(SettingsElement element)
    {
        return settingsProviders.stream().anyMatch(settingsProvider -> settingsProvider.hasValue(element.getKey()));
    }

    /**
     * Creates a new Editor to edit the Settings
     *
     * @return the new Editor
     */
    public Editor edit()
    {
        return new Editor(this);
    }

    void put(SettingsElement element, String value)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.put(element.getKey(), value));
    }

    void delete(SettingsElement element)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.delete(element.getKey()));
    }

    void save()
    {
        settingsProviders.forEach(SettingsProvider::save);
    }
}
